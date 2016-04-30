<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 告诉浏览器本网页符合XHTML1.0过渡型DOCTYPE -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!-- html标识扩展，定义名字空间 -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title></title>
		
	<link rel="StyleSheet" href="../../js/dtree/tdtree/dtree.css" type="text/css" />
	<script type="text/javascript" src="../../js/dtree/tdtree/dtree.js"></script>
	<script type="text/javascript" src="../../js/common.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 5px;
	margin-top: 0px;
	margin-right: 5px;
	margin-bottom: 0px;
}
.tdb {
	background-image: url(images/love_03.jpg);
	background-repeat: no-repeat;
	background-position: right top;
}
td {
	font-size: 12px;
	color: #000000;
	line-height: 18px;
}
.white {
	color: #FFFFFF;
}
.Layer { position:absolute;
	width:260px;filter: Alpha(Opacity=95);
}

.whitep { border:#BB5073 1px solid;background:#ffffff }
.greenp { border:#91AB60 1px solid;background:#EBFDE5 }
.qredp { border:#BB5073 1px solid;background:#FFF0F5 }
.yelp { border:#D19F69 1px solid;background:#FFFFEF }
.bluep { border:#3D65AF 1px solid;background:#E3F3FF }
.bgp { border:#40A8AE 1px solid;background:#E1F5FD }
.yelop { border:#D19F69 1px solid;background:#FFF4E8 }
.pizp { border:#C175AB 1px solid;background:#FEEAF8 }
.pbp { border:#9A7DC3 1px solid;background:#EDE0F4 }
.gbp { border:#69B2AF 1px solid;background:#E8FFFF }


.ceng { position: relative; }
#Layer1 {
	position:absolute;
	left:302px;
	top:119px;
	width:85px;
	height:83px;
	z-index:1;
}
.close {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: bold;
	color: #666666;
}
.gray {
	color: #666666;
}
.styletitle {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 14px;
	font-family: 微软雅黑;
}
.org {
	color: #FF6600;
}
.reg {
	color: #CC3300;
}
.style3 {color: #CC3300; font-weight: bold; }
-->
</style>

<script language="JavaScript1.2">
//-- 控制层删除start of script -->
function ssdel(){
if (event)
{
lObj = event.srcElement ;

while (lObj && lObj.tagName != "DIV") lObj = lObj.parentElement ;
}
var id=lObj.id
     document.getElementById(id).removeNode(true);
     //document.getElementById(id).outerHTML="";//这样也可以;
  }

//-- 控制层删除End of script -->
</script>
<script>
//-- 控制层移动start of script -->
var Obj=''
var index=10000;//z-index;
document.onmouseup=MUp
document.onmousemove=MMove

function MDown(Object){
Obj=Object.id
document.all(Obj).setCapture()
pX=event.x-document.all(Obj).style.pixelLeft;
pY=event.y-document.all(Obj).style.pixelTop;
}

function MMove(){
if(Obj!=''){
 document.all(Obj).style.left=event.x-pX;
 document.all(Obj).style.top=event.y-pY;
 }
}

function MUp(){
if(Obj!=''){
 document.all(Obj).releaseCapture();
 Obj='';
 }
}
//-- 控制层移动end of script -->
//获得焦点;
function getFocus(obj)
{
       if(obj.style.zIndex!=index)
       {
               index = index + 2;
               var idx = index;
               obj.style.zIndex=idx;
               //obj.nextSibling.style.zIndex=idx-1;
       }
}
</script>
<script language="JavaScript" type="text/javascript">

var ie = false;

function getObj(id) {
	if (ie) { return document.all[id]; } 
	else {	return document.getElementById(id);	}
}

function setColor(color) {
	getObj('ccsample').style.background = '' + color;
	getObj('covercolor1').style.background = '' + color;
	getObj('covercolor2').style.background = '' + color;
	getObj('covercolor3').style.background = '' + color;
	getObj('covercolor4').style.background = '' + color;
	getObj('tagcolor').value = ''+color;
}

function setTagBColor(i) {
	color = getBColor(i);
	getObj('preview').style.background = '' + color;
	hopeFM.tagbgcolor.value = i;
	
}

function setTagBPic(i) {
	picurl = getBPic(i);
	getObj('tagBPic').style.background = " transparent url(\"" + picurl + "\") no-repeat scroll bottom left";
	getObj('tagBPic0').value= ''+ i;
	
}

function saveMsg() {
	var Editor = FCKeditorAPI.GetInstance('massages');
	document.getElementById("massages").innerText = Editor.GetXHTML(false);
    var flag = _CheckAll(true,"确定");
    if(typeof flag == 'undefined') {
    	if(chkform()){
		    document.cf.submit();
	    }
    }
}


function getBPic(i) {
	i = (i<1 || i>8)?1:i;
	return "images/" + parseInt(parseInt(i)+0) +".gif";
}
function textCounter(field, countfield, maxlimit) {
	// 定义函数，传入3个参数，分别为表单区的名字，表单域元素名，字符限制；
	if (field.value.length > maxlimit) 
	//如果元素区字符数大于最大字符数，按照最大字符数截断； 
		field.value = field.value.substring(0, maxlimit);
	else
		//在记数区文本框内显示剩余的字符数； 
		countfield.value = maxlimit - field.value.length;
	contentsample.innerHTML = field.value;
}
function chkform() {
	if (cf.author.value == ""){
		alert("雁过留声,人过留名. 请留下您的大名!");
		cf.author.focus();
		return false;
	}
	submitDeptEmpTree();
	return true;
}

function textSyn( ) {
	contentsample.innerHTML = field.value;
}

function killErrors() {
	return true;
}

///window.onerror = killErrors;


	/* 取得部门人员选择的内容 */
	function submitDeptEmpTree(){	
		var deptemps = ""; deptemps = "";
		var form = document.getElementById("cf");
		for (var i=0; i<form.elements.length; i++) {
			var element = form.elements[i];
			if (element.type=='checkbox'){
				if( element.checked == true ){
					if(element.name.indexOf("td_deptEmpId")==0){
						if(element.value.indexOf("#")>=0){					//只记录人员的，部门去掉
							deptemps = deptemps + element.value.substring(element.value.indexOf("#")+1,element.value.length) +',';
						}
					}
				}
			}
		}
		document.forms[0].deptEmpId.value = delLastChar(deptemps);
	}
</script>

	<link rel="stylesheet" rev="stylesheet" type="text/css" href="../../skin/default/css/default.css" media="all" title="default" />
</head>

<body background="images/bg.gif">
<form name="cf" method="post" action="olmsgCreateSaveAction.do">
	<input type="hidden" name="deptEmpId" value=""/>	
	
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="new"><a href="#">确定</a></li>
<li id="back"><a href="#" onclick="history.go(-1);this.blur();">返回</a></li>
</ul>

    </div>
</div>
</div>
</div>


	<!-- 页面主体部分（列表等） -->
	<div class="textbox">
	
	</div>
	<% 
	//字数限制
	int maxlimit=300; %>
	
<div style="padding-left:20px;">
<TABLE border="0">
<TR>
	<TD>
		<fieldset style="width:180px;">
		<legend>
			<div class="styletitle" style="height:40px;width:100px;color:green;padding-top:10px;padding-left:1px;"><b>选择收信人：</b></div>
		</legend>
		<div class="dtree" style="text-align:left;padding-left:6px;">
		
		</div> 
		</fieldset>	
	</TD>
	<TD rowspan="2" valign="top">
			<table border="0" style="border-width: 0px">
				<tr>
					<td style="border-style: none; border-width: medium">　</td>
					<td width="580" style="border-style: none; border-width: medium">
		<table width="580" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td width="18" background="images/love_10.gif"><img src="images/love_09.gif" width="18" height="18" /></td>
		    <td width="544" background="images/love_10.gif">　</td>
		    <td width="18" align="right" background="images/love_10.gif"><img src="images/love_12.gif" width="18" height="18" /></td>
		  </tr>
		  <tr>
		    <td background="images/love_14.gif">　</td>
		    <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td height="25"><span style="margin:10px;background:#70AE0B;width:100%;padding:6px;" class="styletitle">留言板内容: </span></td>
		      </tr>
		    </table>
		       	
		        <table width="100%" border="0" cellspacing="5" cellpadding="2">
				  <tr>
		            <td width="51%" class="gray">
			           <textarea class="input" dataType="非空FCK框" dispName="留言板内容" maxLength="300" id="massages" name="massages" rows="10" onKeyUp="textSyn();"></textarea>
		
					<table cellpadding="2" cellspacing="1" border="0" width="508">
						<tr>
						<td>标签颜色:<input type="hidden" id="tagcolor" name="tagcolor" value="#FFE7E8"></td>
						<td><a href="javascript:setColor('#FFFFFF');"><div id="color330" style="cursor:pointer;border:1px solid #404040;height:25px; width:25px; background: #FFFFFF"></div></a></td>
						<td><a href="javascript:setColor('#FFE7E8');"><div id="color330" style="cursor:pointer;border:1px solid #808080;height:25px; width:25px; background: #FFE7E8"></div></a></td>
						<td><a href="javascript:setColor('#FFEDCC');"><div id="color330" style="cursor:pointer;border:1px solid #808080;height:25px; width:25px; background: #FFEDCC"></div></a></td>
						<td><a href="javascript:setColor('#EDFEB7');"><div id="color330" style="cursor:pointer;border:1px solid #808080;height:25px; width:25px; background: #EDFEB7"></div></a></td>
						<td><a href="javascript:setColor('#C0FFE5');"><div id="color325" style="cursor:pointer;border:1px solid #808080;height:25px; width:25px; background: #C0FFE5"></div></a></td>
						<td><a href="javascript:setColor('#FFE0FB');"><div id="color330" style="cursor:pointer;border:1px solid #404040;height:25px; width:25px; background: #FFE0FB"></div></a></td>
						<td><a href="javascript:setColor('#C9FFC7');"><div id="color330" style="cursor:pointer;border:1px solid #808080;height:25px; width:25px; background: #C9FFC7"></div></a></td>
						<td><a href="javascript:setColor('#CBF3FF');"><div id="color325" style="cursor:pointer;border:1px solid #808080;height:25px; width:25px; background: #CBF3FF"></div></a></td>
						</tr>
					  </table>  
					<table border="0" width="98%" id="table1" cellspacing="0" cellpadding="0" height="55">
						<tr>
							<td width="61">
								选择装饰:
								  <input id="tagBPic0" name="tagBPic" type="hidden" value=0 />
							</td>
							<td align="center"><a href="javascript:setTagBPic('1')">
							<img border="0" src="images/1.gif" width="32" height="31"></a></td>
						<td align="center"><a href="javascript:setTagBPic('2')">
						<img border="0" src="images/2.gif" width="36" height="25"></a></td>
						<td align="center"><a href="javascript:setTagBPic('3')">
						<img border="0" src="images/3.gif" width="39" height="24"></a></td>
						<td align="center"><a href="javascript:setTagBPic('4')">
						<img border="0" src="images/4.gif" width="30" height="33"></a></td>
						<td align="center"><a href="javascript:setTagBPic('5')">
						<img border="0" src="images/5.gif" width="40" height="35"></a></td>
						<td align="center"><a href="javascript:setTagBPic('6')">
						<img border="0" src="images/6.gif" width="32" height="34"></a></td>
						<td align="center"><a href="javascript:setTagBPic('7')">
						<img border="0" src="images/7.gif" width="27" height="28"></a></td>
						<td align="center"><a href="javascript:setTagBPic('8')">
						<img border="0" src="images/8.gif" width="27" height="21"></a></td>
						</tr>
					</table>
					
			<table>
			<tr>
				<td>发信人：</td>
				<td><input name="author" type="text" id="author" onkeyup="javascript:authsample.innerHTML='发信人: '+this.value;" value="${_CURRENT_USER.realName}" maxlength="10" /></td>
				<td>
					<% //班组以上领导拥有发短信的权利, 应该改造为可以在用户权限配置时配置 %>
					<c:if test="${_CURRENT_USER.isSendSms==1}">	
					<input type="checkbox" name="smsNotice" class="input"/>手机短信
					</c:if>				
				</td>
				<td><input type="checkbox" name="backType" class="input"/>需回复</td>
			</tr>
			</table>					
		</td>
		          </tr>
		      </table>
		      
		    </td>
		    <td align="right" background="images/love_16.gif">　</td>
		  </tr>
		  <tr>
		    <td background="images/love_20.gif"><img src="images/love_19.gif" width="18" height="18" /></td>
		    <td background="images/love_20.gif">　</td>
		    <td align="right" background="images/love_20.gif">
		    <img src="images/love_21.gif" width="18" height="18" /></td>
		  </tr>
		</table>
					</td>
				</tr>
			</table>

	</TD>
</TR>
<TR>
	<TD>
		<div id='ccsample' style='border:1px solid #666;margin:5px; width: 150px; height: 100px; background-color: #FFE7E8; z-index: 10002'
			onmousedown='getFocus(this)'>
			
			
			<table border=0 style="word-break: break-all;" width="176" >
				<tr>
				<td id="covercolor1" style='cursor: move;background-color: #FFE7E8;white-space:nowrap;' onmousedown="MDown(ccsample)">
					<fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' value='${olmsg.createdTime}'/>&nbsp;
				</td>
				<td id="covercolor2" style='cursor: hand;background-color: #FFE7E8;' onclick='ssdel()' width='1%' align="right">
				</td>
				</tr>
				<tr>
					<td id="covercolor3" style='height: 100px; padding: 5px;background-color: #FFE7E8;' colspan='2'>
						<div id="contentsample">
							留言板内容
						</div>
					</td>
				</tr>
				<tr>
					<td id=tagBPic
						style='background: url(images/x.gif) no-repeat bottom left; word-wrap: break-word'>
					</td>
					<td id="covercolor4" style='background-color: #FFE7E8;'>
						<div id="authsample" style='padding: 2px; float: right;white-space:nowrap;'>
							发信人: ${_CURRENT_USER.realName}
						</div>
					</td>
				</tr>
			</table>
		</div>	
	</TD>
</TR>
</TABLE>	

</div>	


</form>
</body >
</html>
