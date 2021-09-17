<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

         <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
 
     
    
   <div class="col-md-4 mb-3" style="display: none;">
        <input type="text" id="person_id" class="form-control" value="" required="">
   </div>
    <div class="col-md-4 mb-3" style="display: none;">
        <input type="text" id="pp_id" class="form-control" value="" required="">
   </div>
   <div class="col-md-4 mb-3" style="display: none;">
        <input type="text" id="code" class="form-control" value="" required="">
   </div>
 <!-- basic modal start -->
                    <div class="col-lg-0 mt-0">
                        <div class="card">
                            <div class="card-body">
                             <button type="button" style="display: none;" id="button_alert" class="btn btn-primary btn-flat btn-lg mt-3" data-toggle="modal" data-target="#exampleModalLong">Launch demo modal</button>
                                <!-- Modal -->
                                <div class="modal fade" id="exampleModalLong">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Alert box</h5>
                                              <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                                            </div>
                                            <div class="modal-body">
                                                <p>successfully Updated</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" id="idclose_btn" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

<div class="col-12">
                                <div class="card mt-5">
                                    <div class="card-body">
                                        <h4 class="header-title">Person Register</h4>
                                        <form class="needs-validation" novalidate="">
                                            <div class="form-row">
                                            
                                        
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom02">First name</label>
                                                    <input type="text" id="fname" class="form-control" placeholder="First name" value="" required="">
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>
                                               
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom02">Middel name</label>
                                                    <input type="text" id="mname" class="form-control" placeholder="Middel name" value="" required="">
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>
                                                
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom02">Last name</label>
                                                    <input type="text" id="lname" class="form-control" placeholder="Last name" value="" required="">
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>
                                             
                                                
                                            </div>
                                            <div class="form-row">
                                            
                                              <div class="col-md-4 mb-3">
                                                    <label for="validationCustom04">Address one</label>
                                                    <input type="text" class="form-control" id="add1" placeholder="Address" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid Address.
                                                    </div>
                                                </div>
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom05">Address two</label>
                                                    <input type="text" class="form-control" id="add2" placeholder="Address" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid Address.
                                                    </div>
                                                </div>
                                                
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom05">Address three</label>
                                                    <input type="text" class="form-control" id="add3" placeholder="Address" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid Address.
                                                    </div>
                                                </div>
                                           </div>
                                               
                                            
                                            <div class="form-row">
                                            
                                              <div class="col-md-4 mb-3">
                                                    <div class="form-group">
			                                         <label class="col-form-label">Person Type</label>
			                                            <select class="custom-select" id="p_type">
			                                                <option value="0" selected="selected">Select Person Type</option>
			                                                <option value="1">politician</option>
			                                                <option value="2">Citizen</option>
			                                                
			                                            </select>
	                                        	</div>
                                                </div>
                                                
                                                <div class="col-md-4 mb-3">
                                                  <label for="validationCustom05">Mobile one</label>
                                                  <input type="text" class="form-control" id="mobile1" placeholder="Mobile one" required="">
                                                  <div class="invalid-feedback">
                                                     Please provide a valid Mobile one.
                                                  </div>
                                              </div>
                                                
                                              <div class="col-md-4 mb-3">
                                                   <label for="validationCustom05">Mobile two</label>
                                                   <input type="text" class="form-control" id="mobile2" placeholder="Mobile two" required="">
                                                   <div class="invalid-feedback">
                                                       Please provide a valid Mobile two.
                                                   </div>
                                              </div>
                                                                                    
                                            </div>
                                            
                                             
                                             <div class="form-row">
                                             
                                                                                                 
                                              <div class="col-md-4 mb-3">
                                                  <label for="validationCustom05">Email</label>
                                                  <input type="text" class="form-control" id="Email" placeholder="Email" required="">
                                                  <div class="invalid-feedback">
                                                     Please provide a valid Email.
                                                   </div>
                                              </div>
                                              
                                               <div class="col-md-4 mb-3">
                                                    <label for="validationCustom05">Nic</label>
                                                    <input type="text" class="form-control" id="nic" placeholder="Nic" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid Nic.
                                                    </div>
                                                </div>
                                                
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom05">Fax</label>
                                                    <input type="text" class="form-control" id="fax" placeholder="Fax" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid Fax.
                                                    </div>
                                                </div>
                                              
											</div>
											<div class="form-row">
											 <div class="col-md-4 mb-3">
		                                          <label for="validationCustom05">DOB</label>
		                                            <div class="form-group">
			                                           <input class="form-control"  type="date" value="2020-09-01" id="exampledate">
			                                        </div>
		                                     	</div>
		                                     	
		                                     	
											                           
                                     </div>
                                           
                                     	<hr><p>If Person Type politicians fill that form</p>
                                     	<div class="form-row">
                                     	
                                    		<div class="col-md-4 mb-3">
                                                 <div class="form-group">
			                                         <label class="col-form-label">Team select</label>
			                                            <select id="team_id" class="custom-select">
			                                                <option selected="selected">Select Team</option>
			                                                
			                                            </select>
	                                        	</div>
	                                         </div>
	                                         
	                                         <div class="col-md-4 mb-3">
                                                    <label for="validationCustom05">Reff politicion number</label>
                                                    <input type="text" class="form-control" id="reff_code" placeholder="Reff politicion number" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid reff_code.
                                                    </div>
                                                </div>
                                                
                                       </div>
                                        
                                      <!--  <hr><p>If Person Type citizen fill that form</p>
                                     	<div class="form-row">
                                     	
                                    		<div class="col-md-4 mb-3">
                                                 <div class="form-group">
			                                         <label class="col-form-label">District select</label>
			                                            <select id="district_id" class="custom-select">
			                                                <option selected="selected">Select district</option>
			                                                
			                                            </select>
	                                        	</div>
	                                         </div>
	                                         
	                                         <div class="col-md-4 mb-3">
                                                    <label for="validationCustom05">Reff Citizen number</label>
                                                    <input type="text" class="form-control" id="reff_no" placeholder="Reff Citizen number" required="">
                                                    <div class="invalid-feedback">
                                                        Please provide a valid reff_no.
                                                    </div>
                                                </div>
                                                
                                       </div> -->
				           <div class="col-lg-6 mt-5">
				           	<button class="btn btn-primary" onclick="validation();" type="button">Submit form</button>
				           </div>
                  </form>         
   <div class="card">
   	<div class="card-body">
    	<div class="alert-dismiss" id="alert_box">
        </div>
    </div>
  </div>
  	
  </div>
  </div>
</div>

                         <div class="col-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title">Updates And Delete Only</h4>
                                <div class="single-table">
                                    <div class="table-responsive">
                                       <div class="col-12 mt-5">            
                    
               
               <table id=summary-table class="display nowrap" style="width:100%">
        <thead>
            <tr>
                <th>ID</th>
                <th>Fname</th>
                <th>Otp-code</th>
                <th>mobile1</th>
                <th>Nic</th>
                <th>District</th>
                <th>Status</th>
                <th>Fax</th>
                <th>Edit</th>
                 <th>Delete</th>
            </tr>
        </thead>
        <tbody id="tbodyid">
        
                     
           
            
        </tbody>
        <tfoot>
            <tr>
               <th>ID</th>
               <th>Fname</th>
                <th>Otp-code</th>
                <th>mobile1</th>
                <th>Nic</th>
                <th>District</th>
                <th>Status</th>
                <th>Fax</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </tfoot>
    </table>
                  </div> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                            
           
  		 <script src="https://code.jquery.com/jquery-3.3.1.js"></script>     
         <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>      
         <script src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>      
         <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.flash.min.js"></script>      
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>      
         <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>      
         <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>      
         <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>        
         <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.print.min.js"></script>
                            
                            
       <script type='text/javascript'>
       
       $(document).ready(function () {
    	  // load_table();
    	 //  console.clear();
    	 //load_distric_list();
    	 load_team_list();
    	 load_person_list();
    	   
                              });
       
       
  
  
  
  function Person_save(){
	  //fname,mname,lname,add1,add2,add3,p_type,mobile1,mobile2,Email,nic,exampledate,fax
	  //politions-->> reff_code team_id
	  //citizen-->> reff_no district_id						     
	  	 var person_id = document.getElementById("person_id").value;
	     var fname = document.getElementById("fname").value;
	     var mname = document.getElementById("mname").value;
	     var lname = document.getElementById("lname").value;
	     var add1 = document.getElementById("add1").value;
	     var add2 = document.getElementById("add2").value;
	     var add3 = document.getElementById("add3").value;
	     
	     var mobile1 = document.getElementById("mobile1").value;
	     var mobile2 = document.getElementById("mobile2").value;
	     var Email = document.getElementById("Email").value;
	     var nic = document.getElementById("nic").value;
	     var exampledate = document.getElementById("exampledate").value;
	     var fax = document.getElementById("fax").value;
	     
	     var pp_id = document.getElementById("pp_id").value;
	     var reff_code = document.getElementById("reff_code").value;
	     var team_id = document.getElementById("team_id").value;
	     var code = document.getElementById("code").value;
	     //alert(person_id);
	    if(person_id > 0 && code !="" && pp_id >0){
	    	//("pp_id") ("reff")  ("team_id") ("code") e
	    	 $.ajax({
		            type: "POST",
		            url: "update_politions",
		            data: {"p_id":person_id,"fname":fname,"mname":mname,"lname":lname,"add1":add1,
		                "add2":add2,"add3":add3,"mobile1":mobile1,"mobile2":mobile2,"Email":Email
		                ,"nic":nic,"exampledate":exampledate,"fax":fax,"pp_id":pp_id,"reff":reff_code,"team_id":team_id,"code":code}, // fix: need to append your data to the call
		            success: function (data) {
					
		                    if (data == false) {
		                       $("#alert_box").append("<div class='lert alert-danger alert-dismissible fade show' role='alert'><strong>Data Updated successfully!</strong> You should check in on some of those fields below.<button type='button' id='iderrclose' class='close' data-dismiss='alert' aria-label='Close'><span class='fa fa-times'></span></button></div>");
			                       
		                                setTimeout(function(){ 
		                      $('#iderrclose').trigger('click');
		                      // $( "#button_alert" ).trigger( "click" ); 

		                                                     }, 2000);

		                    } else {
			                    
                           	 $('#button_alert').trigger( 'click' );  
                               setTimeout(function(){ 
                               	 $('#idclose_btn').trigger('click');

                                                    }, 2000);

                           }
		            }
		        });
	    	 
	     }else{
	    	 alert("Select the Candidates Below Table otherwise your can not edit details");
	     }
	                
}
  
  
  
  function load_team_list(){
	  //alert("sss")
			$.ajax({
	           contentType: "application/json",
	           type: "GET",
	           url: "teamlist",
	            success: function (data) {
	            //	alert(data);
	           var myJSON = JSON.stringify(data);
	           //alert(myJSON);
	           var json = JSON.parse(data);
	           
	                   for(var i=0;i<json.length;i++){
	                	   
	                      var id=json[i]['id'];
	                      var name=json[i]['name'];
	                    
	           	      $("#team_id").append("<option value='"+id+"'>"+name+"</option>");
	                   
	                 }            
	                             
	              }
	              
	      });
	  }

  
  function load_distric_list(){
	  //alert("sss")
			$.ajax({
	           contentType: "application/json",
	           type: "GET",
	           url: "distric",
	            success: function (data) {
	            //	alert(data);
	           var myJSON = JSON.stringify(data);
	           //alert(myJSON);
	           var json = JSON.parse(data);
	           
	                   for(var i=0;i<json.length;i++){
	                	   
	                      var id=json[i]['id'];
	                      var name=json[i]['name'];
	                    
	           	      $("#district_id").append("<option value='"+id+"'>"+name+"</option>");
	                   
	                 }            
	                             
	              }
	              
	      });
	  }
  
  
  function load_person_list(){
	 /*  myFunction(); */
	/*  load_table(); */
	  $("#tbodyid").empty();
			$.ajax({
	           contentType: "application/json",
	           type: "GET",
	           url: "get_polition_list",
	            success: function (data) {
		          //alert(data);
	           var json = JSON.parse(data);
	           var trHTML = '';
	           var initial_name="",status_name="";
	           
	                    for(var i=0;i<json.length;i++){
	                    	
	                      var id=json[i]['p_id'];
	                      var fname=json[i]['fname'];
	                      var mname=json[i]['mname'];
	                      var lname=json[i]['lname'];
	                      var add1=json[i]['add1'];
	                      var add2=json[i]['add2'];
	                      var add3=json[i]['add3'];
	                      var register=json[i]['register'];
	                      var status=json[i]['status'];
	                      var dob=json[i]['dob'];
	                      var mobile1=json[i]['mobile1'];
	                      var mobile2=json[i]['mobile2'];
	                      var email=json[i]['email'];
	                      var fax=json[i]['fax'];
	                      var nic=json[i]['nic'];
	                      
	                      var pp_id=json[i]['pp_id'];
	                      var poli_status=json[i]['poli_status'];
	                      var reff=json[i]['reff'];
	                      var team_id=json[i]['team_id'];
	                      var team_name=json[i]['team_name'];
	                      var code=json[i]['otpcode'];
	                                           
	                      
	                      if(status == 1){
	                    	  status_name="Active"; 
	                      }else if(status == 2){
	                    	  status_name="Deactivate"; 
	                      }
	                            
	                      trHTML +='<tr><th scope="row">'+ pp_id +'</th><td>'+fname+'</td><td><span class="status-p bg-danger">'+code+'</span></td><td>'+mobile1+'</td><td>'+nic+'</td><td>'+team_name+'</td><td><span class="status-p bg-primary">'+status_name+'</span></td><td><span class="status-p bg-primary">'+fax+'</span></td><td><button type="button" onclick=edit(\''+encodeURIComponent(id)+'\',\''+encodeURIComponent(fname)+'\',\''+encodeURIComponent(mname) +'\',\''+encodeURIComponent(lname) +'\',\''+encodeURIComponent(add1)+'\',\''+encodeURIComponent(add2)+'\',\''+encodeURIComponent(add3)+'\',\''+encodeURIComponent(dob)+'\',\''+encodeURIComponent(mobile1)+'\',\''+encodeURIComponent(mobile2)+'\',\''+encodeURIComponent(email)+'\',\''+encodeURIComponent(fax)+'\',\''+encodeURIComponent(nic)+'\',\''+encodeURIComponent(pp_id) +'\',\''+encodeURIComponent(reff) +'\',\''+encodeURIComponent(team_id) +'\',\''+encodeURIComponent(code) +'\'); class="btn btn-default bg-primary">Edit</button></td><td><button type="button" onclick=delete_fun(\''+encodeURIComponent(pp_id)+'\',\''+encodeURIComponent(id)+'\'); class="btn btn-default bg-danger">Delet</td></tr>';
     
	                 } 
	                    $( "#summary-table tbody" ).append(trHTML);
	                    load_table();
	                             
	              }
	              
	      });
	  }
  
  
  function edit(id,fname,mname,lname,add1,add2,add3,dob,mobile1,mobile2,email,fax,nic,pp_id,reff_no,team_id,code){
	//alert((decodeURIComponent(firstname)));
	//fname,mname,lname,add1,add2,add3,p_type,mobile1,mobile2,Email,nic,exampledate,fax
	//citizen-->> reff_no district_id	
	     $("#person_id").val((decodeURIComponent(id)));
	     $("#fname").val((decodeURIComponent(fname)));
	     $("#mname").val((decodeURIComponent(mname)));
	     $("#lname").val((decodeURIComponent(lname)));
	     $("#add1").val((decodeURIComponent(add1)));
	     $("#add2").val((decodeURIComponent(add2)));
	     $("#add3").val((decodeURIComponent(add3)));
	     $("#exampledate").val((decodeURIComponent(dob)));
	     $("#mobile1").val((decodeURIComponent(mobile1)));
	     $("#mobile2").val((decodeURIComponent(mobile2)));
	     $("#Email").val((decodeURIComponent(email)));
	     $("#fax").val((decodeURIComponent(fax)));
	     $("#nic").val((decodeURIComponent(nic)));
	     $("#p_type").val((decodeURIComponent("1")));
	     $("#pp_id").val((decodeURIComponent(pp_id)));
	     $("#reff_code").val((decodeURIComponent(reff_no)));
	     $("#team_id").val((decodeURIComponent(team_id)));
	     $("#code").val((decodeURIComponent(code))); 
  
	}
  

  function myFunction() {
	// console.clear();
  }
  
  function load_table(){
	 
	  $.extend($.fn.dataTable.defaults, {
	    dom: 'Bfrtip'
	    /* buttons: ['copy', 'csv', 'excel', 'pdf', 'print'] */
	  });

	  $("#summary-table").DataTable();	  	  	  		 
  }
    
  
  function delete_fun(pp_id,p_id){
	  $.ajax({
          type: "Delete",
          url: "delete_polition",
          data: {"pp_id":pp_id,"p_id":p_id}, // fix: need to append your data to the call
          success: function (data) {
			
                  if (data == false) {
                     $("#alert_box").append("<div class='lert alert-danger alert-dismissible fade show' role='alert'><strong>Data Deleted successfully!</strong> You should check in on some of those fields below.<button type='button' id='iderrclose' class='close' data-dismiss='alert' aria-label='Close'><span class='fa fa-times'></span></button></div>");
	                       
                              setTimeout(function(){ 
                    $('#iderrclose').trigger('click');
                    // $( "#button_alert" ).trigger( "click" ); 

                                                   }, 2000);

                  } else {
	                    
                 	 $('#button_alert').trigger( 'click' );  
                     setTimeout(function(){ 
                     	 $('#idclose_btn').trigger('click');

                                          }, 2000);

                 }
          }
      });
  }
  
  function validation(){
	  //fname,mname,lname,add1,add2,add3,p_type,mobile1,mobile2,Email,nic,exampledate,fax
	  //politions-->> reff_code team_id
	  //citizen-->> reff_no district_id	
     
     				     if(document.getElementById("p_type").selectedIndex == 0) {
                       	 document.getElementById("p_type").style.borderColor = "#E34234";
                          return false;
                   	  	} else if(document.getElementById("fname").value == "") {
                         document.getElementById("fname").style.borderColor = "#E34234";
                          return false;
                      	}else if(document.getElementById("mname").value =="") {
                          document.getElementById("mname").style.borderColor = "#E34234";
                          return false;
                  		 }
                   	  	else if(document.getElementById("lname").value =="") {
                          document.getElementById("lname").style.borderColor = "#E34234";
                             return false;
                      	} else if(document.getElementById("add1").value == "") {
                          document.getElementById("add1").style.borderColor = "#E34234";
                             return false;
                      	} else if(document.getElementById("add2").value == "") {
                          document.getElementById("add2").style.borderColor = "#E34234";
                             return false;
                      	} else if(document.getElementById("add3").value == "") {
                          document.getElementById("add3").style.borderColor = "#E34234";
                          return false;
                   	  	}
                        else if(document.getElementById("mobile1").value == "") {
                          document.getElementById("mobile1").style.borderColor = "#E34234";
                          return false;
                        }
                        else if(document.getElementById("mobile2").value == "") {
                          document.getElementById("mobile2").style.borderColor = "#E34234";
                          return false;
                        }
                        else if(document.getElementById("Email").value == "") {
                            document.getElementById("Email").style.borderColor = "#E34234";
                            return false;
                        }
                     	 else if(document.getElementById("nic").value == "") {
                          document.getElementById("nic").style.borderColor = "#E34234";
                          return false;
                     	 }

     					 else{
    	 
						    	  var phoneno = /^\d{10}$/;
						    	  var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
						    	    if(document.getElementById("mobile1").value.match(phoneno) && document.getElementById("mobile2").value.match(phoneno) &&
						    	    		document.getElementById("Email").value.match(mailformat))
						    	          {
						    	    	 	  Person_save();
						    	       		  return true;
						    	          }
						    	        else
						    	          {
							    	          alert("Mobile number Not Valid OR Email not Valid check it");
							    	         // document.getElementById("mobile1").style.borderColor = "#E34234";
						    	         	  return false;
						    	          }
      							}
  }
  
  
</script>                     