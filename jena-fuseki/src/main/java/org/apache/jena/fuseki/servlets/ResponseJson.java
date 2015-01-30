package org.apache.jena.fuseki.servlets;

import static java.lang.String.format;
import static org.apache.jena.fuseki.servlets.ServletBase.errorOccurred;
import static org.apache.jena.fuseki.servlets.ServletBase.log;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.jena.atlas.json.JsonArray;
import org.apache.jena.fuseki.FusekiException;
import org.apache.jena.fuseki.servlets.ResponseResultSet.OutputContent;
import org.apache.jena.riot.WebContent;
import org.apache.jena.web.HttpSC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.hpl.jena.query.QueryCancelledException;
import com.hp.hpl.jena.query.ResultSetFormatter;

public class ResponseJson {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultSet.class) ;
	private static final Logger SERVLET_LOGGER = ServletBase.log ;

	public static void doResponseJson(HttpAction action, JsonArray jsonArray) {
		if ( jsonArray == null)
        {
			LOGGER.warn("doResponseJson: Result set is null") ; 
            throw new FusekiException("Result set is null") ;
        }
		
		jsonOutput(action, jsonArray);
	}

	private static void jsonOutput(HttpAction action, final JsonArray jsonArray) {
		OutputContent proc = new OutputContent(){
            @Override
            public void output(ServletOutputStream out)
            {
                try {
	                out.print(jsonArray.toString());
                } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
                }
            }
        } ;
        
        try {
            String callback = ResponseOps.paramCallback(action.request) ;
            ServletOutputStream out = action.response.getOutputStream() ;

            if ( callback != null )
            {
                callback = StringUtils.replaceChars(callback, "\r", "") ;
                callback = StringUtils.replaceChars(callback, "\n", "") ;
                out.print(callback) ;
                out.println("(") ;
            }

            output(action, "application/json", WebContent.charsetUTF8, proc) ;

            if ( callback != null )
                out.println(")") ;
        } catch (IOException ex) { errorOccurred(ex) ; }
    }
	
	private static void output(HttpAction action, String contentType, String charset, OutputContent proc) 
    {
        try {
            setHttpResponse(action.request, action.response, contentType, charset) ; 
            action.response.setStatus(HttpSC.OK_200) ;
            ServletOutputStream out = action.response.getOutputStream() ;
            try
            {
                proc.output(out) ;
                out.flush() ;
            } catch (QueryCancelledException ex) {
                // Bother.  Status code 200 already sent.
            	SERVLET_LOGGER.info(format("[%d] Query Cancelled - results truncated (but 200 already sent)", action.id)) ;
                out.println() ;
                out.println("##  Query cancelled due to timeout during execution   ##") ;
                out.println("##  ****          Incomplete results           ****   ##") ;
                out.flush() ;
                // No point raising an exception - 200 was sent already.  
                //errorOccurred(ex) ;
            }
        // Includes client gone.
        } catch (IOException ex) 
        { errorOccurred(ex) ; }
        // Do not call httpResponse.flushBuffer(); here - Jetty closes the stream if it is a gzip stream
        // then the JSON callback closing details can't be added. 
    }
	
	public static void setHttpResponse(HttpServletRequest httpRequest,
            HttpServletResponse httpResponse,
            String contentType, String charset) 
	{
		// ---- Set up HTTP Response
		// Stop caching (not that ?queryString URLs are cached anyway)
		if ( true )
		{
			httpResponse.setHeader("Cache-Control", "no-cache") ;
			httpResponse.setHeader("Pragma", "no-cache") ;
		}
		// See: http://www.w3.org/International/O-HTTP-charset.html
		if ( contentType != null )
		{
			if ( charset != null )
				contentType = contentType+"; charset="+charset ;
			log.trace("Content-Type for response: "+contentType) ;
			httpResponse.setContentType(contentType) ;
		}
	}
	
}
