<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function addApply(){
				window.location.href = "${pageContext.request.contextPath}/publicdevice/PublicDeviceAction_list.do";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<s:form id="form1" name="form1" action="/student/StudentAction_list.do" method="post">
		
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>

					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>报 修 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
									<td align="center" width="12%">
										学号
									</td>
									<td align="center" width="12%">
										姓名
									</td>
									<td align="center" width="12%">
										报修项目
									</td>
									<td align="center" width="12%">
										单价
									</td>
									<td width="11%" align="center">
										数量
									</td>
									<td width="11%" align="center">
										总计
									</td>
									<td width="17%" align="center">
										缴费时间
									</td>
								</tr>
								<s:iterator value="#request.chargeList" var="charge">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="12%">
												<s:property value="#charge.loginName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="12%">
												<s:property value="#charge.sname"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="12%">
												<s:property value="#charge.deviceName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="12%">
												<s:property value="#charge.devicePrice"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												<s:property value="#charge.applyNumber"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												<s:property value="#charge.sumPrice"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#charge.date"/>
											</td>
											
										</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
		<s:debug></s:debug>
	</body>
</HTML>

