/*******************************************************************************
*
* Pentaho Big Data
*
* Copyright (C) 2002-2014 by Pentaho : http://www.pentaho.com
*
*******************************************************************************
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
******************************************************************************/

package org.pentaho.hadoop.shim.cdh51.authorization;

import org.pentaho.hadoop.shim.common.authorization.NoOpHadoopAuthorizationService;
import org.pentaho.hbase.shim.cdh51.HBaseConnectionImpl;
import org.pentaho.hbase.shim.common.CommonHBaseShim;
import org.pentaho.hbase.shim.common.HBaseShimImpl;
import org.pentaho.hbase.shim.spi.HBaseConnection;

public class ShimNoOpHadoopAuthorizationService extends NoOpHadoopAuthorizationService {

  @Override protected CommonHBaseShim getHbaseShim() {
    /* Todo: refactored as it was before - but need to check may be after if
         new variant will work with old shim
         Moreover seems that common variant contains some fixes */
    return new HBaseShimImpl() {
      @Override public HBaseConnection getHBaseConnection() {
        return new HBaseConnectionImpl();
      }
    };
  }
}
