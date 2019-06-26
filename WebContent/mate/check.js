
var xmlHttp;
  
  function createXMLHttp(){	
  if(window.XMLHttpRequest){
	  xmlHttp = new XMLHttpRequest();
  }
  else{
	  xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
      }
 
 function checkMName(svalue){
	  createXMLHttp();
	  xmlHttp.open("post","User?name="+svalue,true);
	  xmlHttp.onreadystatechange=function() {
		  if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			  var flag = xmlHttp.responseText;
			  if(flag == "0"){
				  document.getElementById("msg") . innerHTML="不存在该用户";
			  }
			  else if(flag=="1"){
				  document.getElementById("msg") . innerHTML="该用户名存在";
			  }
			  
	  }
	 
	  
	  
  };  xmlHttp.send(null);
 }