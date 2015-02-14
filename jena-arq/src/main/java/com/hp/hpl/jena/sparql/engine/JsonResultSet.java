package com.hp.hpl.jena.sparql.engine;

import java.util.Iterator;
import java.util.List;

import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.atlas.json.JsonValue;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.sparql.core.Var;
import com.hp.hpl.jena.sparql.engine.binding.Binding;

/**
 * Wraps a Query Iterator, always returning the Binding element converted into
 * a JsonValue.
 */
public class JsonResultSet implements Iterator<JsonValue> {

    private QueryIterator queryIterator;
    private List<String> resultVars;

    public JsonResultSet(QueryIterator queryIterator, List<String> resultVars) {
        this.queryIterator = queryIterator;
        this.resultVars = resultVars;
    }

    @Override
    public boolean hasNext() {
        return queryIterator.hasNext();
    }

    @Override
    public JsonValue next() {
        Binding binding = queryIterator.next();
        JsonObject jsonObject = new JsonObject(); 
        for (String resultVar : resultVars) {
            Node n = binding.get(Var.alloc(resultVar));
            if (n.isLiteral()) {
                jsonObject.put(resultVar, n.getLiteral().toString());
            }
        }
        return jsonObject;
    }

    @Override
    public void remove() {
        queryIterator.remove();
    }

}
