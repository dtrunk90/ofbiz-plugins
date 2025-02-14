/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
*/
package org.apache.ofbiz.birt.order

productStoreId = parameters.productStoreId
DateTime = org.apache.ofbiz.base.util.UtilDateTime.nowTimestamp()
String DateStr = DateTime
DateDay = DateStr.substring(0,10)
DateMonth = DateStr.substring(5,7)
DateYear = DateStr.substring(0,4)

if ("01" == DateMonth||"03" == DateMonth||"05" == DateMonth||"07" == DateMonth||"08" == DateMonth||"10" == DateMonth||"12" == DateMonth)
{
    NunberDate = 31
}
else if ("02" == DateMonth)
{
    NunberDate = 29
}
else
{
    NunberDate = 30
}

birtParameters = [:]
try {
    birtParameters.productStoreId = productStoreId
    birtParameters.DateDay = DateDay
    birtParameters.DateMonth = DateMonth
    birtParameters.DateYear = DateYear
    birtParameters.NunberDate = NunberDate
} catch (e) {
    logError(e)
}

request.setAttribute("birtParameters", birtParameters)

return "success"
