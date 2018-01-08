

<h1 style="color:red">Start Generating Report</h1>
<script language="JavaScript">
  function validate(frm){
      document.getElementById("errMsg").innerHTML="";
        //validation logic
      if(frm.pageSize.value==""){
         document.getElementById("errMsg").innerHTML="Page size is required";
         return false;
      }  
      else{
        if(frm.pageSize.value<=0){
           document.getElementById("errMsg").innerHTML="Page size must be numeric value";
           return false;
        }//if
      }//else
    return true;
  }//validate(-)
</script>

<form action="controller"  method="post" onsubmit="return validate(this)">
  Choose Page SIZE(>0) :: <input type="text" name="pageSize" /> <span style="color:red" id="errMsg"></span> <br>
  <input type="submit"  value="GenerateReport"/>
</form>
