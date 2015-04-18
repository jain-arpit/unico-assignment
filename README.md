# unico-assignment


1.  For adding two integers to JMS queue use:

 **Request Type :** POST
 **Request Url :** http://{baseUrl}/api/rest/push
 **Query parameters:** *num1* & *num2*
 **Respose Type**: JSON
 **Success Response**: {result: "CREATED"}

2. For Listing queue elements:

 **Request Type :** GET
 **Request Url :** http://{baseUrl}/api/rest/list
 **Respose Type**: JSON
 **Success Response**: {"messages":[9,81,9,81,..]}

3. For SOAP wsdl use below link:

 http://{baseUrl}/services/soap?wsdl


*Note: soap request for gcd will return -1 in case of queue underflow.*