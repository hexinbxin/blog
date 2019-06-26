
var xmlHttp;
  
  function createXMLHttp(){	
  if(window.XMLHttpRequest){
	  xmlHttp = new XMLHttpRequest();
  }
  else{
	  xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
      }
 
 function checkName(svalue){
	  createXMLHttp();
	  xmlHttp.open("post","Rigister?name="+svalue,true);
	  xmlHttp.onreadystatechange=function() {
		  if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			  var flag = xmlHttp.responseText;
			  if(flag == "0"){
				  document.getElementById("msg") . innerHTML="可以使用";
			  }
			  else if(flag=="1"){
				  document.getElementById("msg") . innerHTML="用户名已经存在,请更换用户名";
			  }		  
	  }  
  };  xmlHttp.send(null);
 }