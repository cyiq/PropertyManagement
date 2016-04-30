<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
		<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.4.2.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick-zh-CN.js"></script>
	</HEAD>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#applyNumber").change(
				function(){
					var price = $("#devicePrice").val();
					var num = $("#applyNumber").val();
					var sum = price * num;
					$("#sumPrice").val(sum);
				}		
			);
			$("#deviceName").attr("disabled",true);
			$("#devicePrice").attr("disabled",true);
			$("#sumPrice").attr("disabled",true);
			$("#sname").attr("disabled",true);
			$("#submit").click(
				function(){
					$("#deviceName").attr("disabled","");
					$("#devicePrice").attr("disabled","");
					$("#sumPrice").attr("disabled","");
					$("#sname").attr("disabled","");
				}		
			);
		});
	</script>
	<body>
		<s:form id="form1" name="form1" action="/apply/ApplyAction_update.do" method="post" enctype="multipart/form-data">
			&nbsp;
			<s:hidden  name="sid" id="sid"/>
			<s:hidden name="applyId" id="applyId"/>
			<s:hidden name="deviceId" id="deviceId"/>
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>报 修 信 息</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						报修项目：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="deviceName" id="deviceName"  cssClass="bg"></s:textfield>
					</td>
				
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						单价：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<s:textfield name="devicePrice" id="devicePrice"  cssClass="bg" onchange=""></s:textfield>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						数量：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="applyNumber"  id="applyNumber" ></s:textfield>
					</td>
					
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						申请人：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="sname" id="sname"  cssClass="bg"></s:textfield>
					</td>
				<TR>
					<TD class="ta_01" align="center" bgColor="#f5fafe">
						总计：
					</TD>
					<TD class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textfield name="sumPrice" id="sumPrice"> </s:textfield>
					</TD>
				</TR>
				<TR>
					<td align="center" colSpan="4" class="sep1">
						<img src="${pageContext.request.contextPath}/images/shim.gif">
					</td>
				</TR>


				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<s:submit id="submit" name="submit" cssClass="button_ok" value="确定"></s:submit>
						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<s:reset type="reset" value="重置" ccsClass="button_cancel"></s:reset>
						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<s:submit type="button" value="返回" onclick="history.go(-1)" cssClass="button_ok"></s:submit>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
			</s:form>
		<s:debug></s:debug>




	</body>
</HTML>