<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function addDevice(){
				window.location.href = "${pageContext.request.contextPath}/publicdevice/PublicDeviceAction_add.do";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<s:form id="form1" name="form1" action="/publicdevice/PublicDeviceAction_list.do" method="post">
			
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
	
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>公 共 设 备 列 表 </strong>
						</TD>
					</tr>
					<s:if test="#session.isStudent">
					</s:if>
					<s:else>
					<tr>
						<td class="ta_01" align="right">
							<input type="button" value="添加" onclick="addDevice()" class="button_view">
						</td>
					</tr>
					</s:else>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										设备名
									</td>
									<td align="center" width="17%">
										设备价格
									</td>
									<td width="11%" align="center">
										数量
									</td>
									<s:if test="#session.isStudent">
									</s:if>
									<s:else>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
									</s:else>
									
									<s:if test="#session.isStudent">
									<td width="7%" align="center">
										报修
									</td>
									</s:if>
								</tr>
								<s:iterator value="#request.publicDeviceList" var="publicDevice">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												<s:property value="#publicDevice.deviceName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#publicDevice.devicePrice"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												<s:property value="#publicDevice.deviceNum"/>
											</td>
											<s:if test="#session.isStudent">
											</s:if>
											<s:else>
												<td align="center" style="HEIGHT: 22px">
													<a href="${pageContext.request.contextPath}/publicdevice/PublicDeviceAction_edit.do?deviceId=<s:property value="#publicDevice.deviceId"/>">
														<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
													</a>
												</td>
												<td align="center" style="HEIGHT: 22px">
													<a href="${pageContext.request.contextPath}/publicdevice/PublicDeviceAction_delete.action?deviceId=<s:property value="#publicDevice.deviceId"/>">
														<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
													</a>
												</td>
											</s:else>
											
											<s:if test="#session.isStudent">
												<td align="center" style="HEIGHT: 22px">
													<a href="${pageContext.request.contextPath}/apply/ApplyAction_add.do?deviceId=<s:property value="#publicDevice.deviceId"/>&loginName=<s:property value="#session.loginName"/>">
														<img src="${pageContext.request.contextPath}/images/hotel_dire_arrowc.jpg" border="0" style="CURSOR: hand">
														报修
													</a>
												</td>
											</s:if>
											
										</tr>
								</s:iterator>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
	</body>
</HTML>

