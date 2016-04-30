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
	</script>
	<body>
		<form name="Form1" method="post" action="name.aspx" id="Form1">

	<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
				<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr>
								<td class="ta_01" align="center" bgColor="#afd1f3" colspan="3">
									<strong>员 工 列 表</strong>
								</td>
								</tr>
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										登录名
									</td>
									<td align="center" width="17%">
										姓名
									</td>
									<td align="center" width="17%">
										发消息
									</td>
								</tr>
		<s:iterator value="#request.employeeList" var="employee">		
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
												<s:property value="#employee.loginName"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
												<s:property value="#employee.userName"/>
										</td>
										<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/message/messageAction_setMessage.do?id=<s:property value="#employee.id"/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
										</td>	
		</s:iterator>
	</form>
	<form name="Form2" method="post" action="name.aspx" id="Form2">
								
						<s:iterator value="#request.studentList" var="student">		
							<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
												<s:property value="#student.loginName"/>
										</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
												<s:property value="#student.sname"/>
									<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/message/messageAction_setMessage.do?sid=<s:property value="#student.sid"/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
									</td>
							</tr>
						</s:iterator>
	</table>
	</form>
		<s:if test="#request.showStudentMessage">
		<s:form id="form1" name="form1" action="" method="post" enctype="multipart/form-data">
			&nbsp;
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colspan="4">
						<strong>消息列表</strong>
					</td>
				</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
									<td align="center" width="17%">
										id
									</td>
									<td align="center" width="17%">
										发信人
									</td>
									<td align="center" width="17%">
										消息内容
									</td>
									<td align="center" width="17%">
										删除
									</td>
					</tr>
					<s:iterator value="#request.listMessage" var="smessage" status="mid">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
													<s:property value="#mid.Index"/>
												</td>
											<s:iterator value="smessage" var="smessage" status="mmid">	
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
													width="17%">
												
													<s:property value="#smessage"/>
												</td>
											</s:iterator>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/message/messageAction_delete.do?mid=<s:property value="#mid.Index"/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											
											</td>
									 </tr>
					</s:iterator>
				</table>
						</td>
					</tr>
		</s:form>
		</s:if>
		<s:else>
		<s:form id="form2" name="form2" action="" method="post" enctype="multipart/form-data">
			&nbsp;
			<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>消息 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
									<td align="center" width="17%">
										id
									</td>
									<td align="center" width="17%">
										发件人
									</td>
									<td align="center" width="17%">
										消息内容
									</td>
									<td align="center" width="17%">
										删除消息
									</td>
					</tr>
					<s:iterator value="#request.listMessage" var="message" status="mid">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
													<s:property value="#mid.Index"/>
												</td>
											<s:iterator value="message" var="message" status="mmid">	
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
													width="17%">
												
													<s:property value="#message"/>
												</td>
											</s:iterator>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/message/messageAction_delete.do?mid=<s:property value="#mid.Index"/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											
											</td>
									 </tr>
					</s:iterator>
				</table>
						</td>
					</tr>
		</s:form>
		</s:else>
		<s:debug></s:debug>
	</body>
</HTML>