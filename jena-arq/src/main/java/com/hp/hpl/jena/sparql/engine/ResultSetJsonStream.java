/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hp.hpl.jena.sparql.engine;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.jena.atlas.lib.Closeable;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.sparql.core.ResultBinding;
import com.hp.hpl.jena.sparql.engine.binding.Binding;

/** 
 * A ResultSet implementation for returning results from JSON queries.
 * This version is "use once" - you can not reset the result set because
 * the results of the query are not remembered so as not to consume potentially
 * large amounts of memory.
 */
public class ResultSetJsonStream implements ResultSet {

    private QueryIterator queryIterator ;
    private List<String> resultVars ;
    private int rowNumber ;
    private QuerySolution querySolution ;

    /**
     * Constructor with parameters.
     * @param queryIterator Query iterator containing results
     * @param resultVars Result variables names
     */
    public ResultSetJsonStream(QueryIterator queryIterator, List<String> resultVars) {
        this.queryIterator = queryIterator ;
        this.resultVars = resultVars ;
        rowNumber = 0 ;
        querySolution = null ;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException(this.getClass().getName()+".remove") ;
    }

    @Override
    public boolean hasNext() {
        if ( queryIterator == null )
            return false ;
        boolean r = queryIterator.hasNext() ;
        if ( !r )
            close() ;
        return r;
    }

    /**
     * Closes the iterator if it is an instance of Closeble.
     */
    private void close()
    {
        if ( queryIterator instanceof Closeable )
            ((Closeable) queryIterator).close() ;
    }

    @Override
    public QuerySolution next() {
        return nextSolution() ;
    }

    @Override
    public QuerySolution nextSolution() {
        if ( queryIterator == null )
          throw new NoSuchElementException(this.getClass()+".next") ;

      Binding binding = nextBinding() ;
      querySolution = new ResultBinding(null, binding) ;
      return querySolution ;
    }

    @Override
    public Binding nextBinding() {
        if ( queryIterator == null ) {
            throw new NoSuchElementException(this.getClass() + ".next") ;
        }

        try {
            Binding binding = queryIterator.next() ;
            if (binding != null) { 
                rowNumber++ ;
            }
            return binding ;
        } catch (NoSuchElementException ex) {
            close() ;
            throw ex ;
        }
    }

    @Override
    public int getRowNumber() {
        return rowNumber ;
    }

    @Override
    public List<String> getResultVars() {
        return resultVars ;
    }

    /**
     * Always return null. This JSON result set streams the results without ever using
     * a Model object.
     */
    @Override
    public Model getResourceModel() {
        return null ;
    }

}
