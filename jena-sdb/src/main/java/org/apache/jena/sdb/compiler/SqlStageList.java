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

package org.apache.jena.sdb.compiler;

import java.util.ArrayList;

import org.apache.jena.atlas.lib.StrUtils;
import org.apache.jena.sdb.core.SDBRequest ;
import org.apache.jena.sdb.core.sqlnode.SqlNode ;

public class SqlStageList extends ArrayList<SqlStage>
{
    public SqlNode build(SDBRequest request, SlotCompiler slotCompiler)
    {
        SqlNode sqlNode = null ;
        // See QuadCompilerBase.compile
        for ( SqlStage s : this )
        {
            SqlNode sNode = s.build(request, slotCompiler) ;
            if ( sNode != null )
                sqlNode = SqlBuilder.innerJoin(request, sqlNode, sNode) ;
        }
        
        return sqlNode ;
    }

    
    @Override
    public String toString()
    {
        String str = "SqlStageList::" ;
        
        if ( isEmpty() )
            str = str + " (empty)" ;
        else
            str = str + " "+ StrUtils.strjoin(this, " // " ) ;
        //str = str + "\n" ;
        return str ;
    }
}
