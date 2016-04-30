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
	<body>
		<s:form id="form1" name="form1" action="/notice/noticeAction_save.do" method="post" enctype="multipart/form-data">
			&nbsp;
			<s:token></s:token>
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加公告</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						公告标题：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="noticeTitle" id="noticeTitle" cssClass="bg"></s:textfield>
					</td>
				
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						公告内容：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<s:textarea name="noticeContent" cols="30" rows="3" id="noticeContent" style="WIDTH: 96%"> </s:textarea>
					</td>
				</tr>
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
			<form name="Form1" method="post" action="name.aspx" id="Form1">
				&nbsp;
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr>
									<td class="ta_01" align="center" bgColor="#afd1f3" colspan="3">
										<strong>公告 列 表</strong>
									</td>
								</tr>
								<s:iterator value="#session.noticeList" var="notice">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												<s:property value="#notice.noticeTitle"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/notice/noticeAction_editUI.do?noticeId=<s:property value="#notice.noticeId"/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/notice/noticeAction_delete.do?noticeId=<s:property value="#notice.noticeId"/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
			</form>
	</body>
</HTML>