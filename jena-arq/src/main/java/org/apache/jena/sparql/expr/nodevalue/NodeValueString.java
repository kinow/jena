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

package org.apache.jena.sparql.expr.nodevalue;

import org.apache.jena.graph.Node ;
import org.apache.jena.graph.NodeFactory ;
import org.apache.jena.sparql.expr.NodeValue ;
import org.apache.jena.sparql.util.FmtUtils ;


public class NodeValueString extends NodeValue
{
    // A plain string, with no language tag, or an xsd:string.
    
    private String string ; 
    private final String collation;

    public NodeValueString(String str)         { this(str, (String) null); }
    public NodeValueString(String str, String collation)         { string = str ; this.collation = collation; }
    public NodeValueString(String str, Node n) { this(str, n, (String) null); }
    public NodeValueString(String str, Node n, String collation) { super(n) ; string = str ; this.collation = collation; }
    
    @Override
    public boolean isString() { return true ; }
    
    @Override
    public String getString() { return string ; }

    @Override
    public String asString() { return string ; }

    @Override
    public String getCollation() { return collation ; }

    @Override
    public String toString()
    { 
        if ( getNode() != null )
        {
            // Can be a plain string or an xsd:string.
            return FmtUtils.stringForNode(getNode()) ;
        }
        return '"'+string+'"'  ;
    }
    
    @Override
    protected Node makeNode()
    { return NodeFactory.createLiteral(string) ; }
    
    @Override
    public void visit(NodeValueVisitor visitor) { visitor.visit(this) ; }
}
