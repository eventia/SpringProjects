<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.net.*" %>
<%@ page import="javax.xml.*" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="org.w3c.dom.*" %>
<%
	URL url = null;
	URLConnection urlConnection = null;
	
//	String stringUrl = "http://www.sample.kr/openapi/SttsApiTblData.do?STATBL_ID=T186503126543136&DTACYCLE_CD=QY&WRTTIME_IDTFR_ID=201704&Type=json";
	String stringUrl = "https://open.assembly.go.kr/portal/openapi/ngytonzwavydlbbha?DAE_NUM=21&CONF_DATE=2023-04&Type=json";
	InputStream is = null;
	String data = "";
	
	try {
		
		url = new URL(stringUrl);
		urlConnection = url.openConnection();
		urlConnection.setDoOutput(true);
		
		is = urlConnection.getInputStream();
		 
	 	byte[] buf = new byte[2048];
	 	int len = -1;
	 	StringBuffer sb = new StringBuffer();
	 	
	 	while ((len = is.read(buf, 0, buf.length)) != -1) {
	 		sb.append(new String(buf, 0, len));
	 	}
		
	 	data = sb.toString();
	 	
	} catch (MalformedURLException e) {
		e.getMessage();
	} catch (IOException e) {
		e.getMessage();
	} finally {
		if (is != null) {
			is.close();
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	java sample page
	<%=data%>;
</body>
</html>
