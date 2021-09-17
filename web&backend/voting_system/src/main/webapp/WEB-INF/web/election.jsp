<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

         <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
 
     
    
   <div class="col-md-4 mb-3" style="display: none;">
        <input type="text" id="id" class="form-control" value="" required="">
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
                                                <p>successfully Done</p>
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
                                        <h4 class="header-title">Election Register</h4>
                                        <form class="needs-validation" novalidate="">
                                            <div class="form-row">
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationCustom02">Election Name</label>
                                                    <input type="text" id="fname" class="form-control" placeholder="Election name" value="" required="">
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>                                                
                                            </div>
                                 
                                       
                                     	
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
                                <h4 class="header-title">Table</h4>
                                <div class="single-table">
                                    <div class="table-responsive">
                                       <div class="col-12 mt-5">            
                    
               
               <table id=summary-table class="display nowrap" style="width:100%">
        <thead>
            <tr>
                <th>ID</th>
                <th>Fname</th>
                <th>Regtime</th>
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
                <th>Regtime</th>
                
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
    	
    	  console.clear();
    	
    	 load_person_list();
    	   
                              });
       
       
  
  
  
  function save(){
	 				     
	  	 var id = document.getElementById("id").value;
	     var fname = document.getElementById("fname").value;
	     
	    if(id > 0){
	   //update
	     	 $.ajax({
		            type: "POST",
		            url: "updateelection",
		            data: {"name":fname,"id":id}, // fix: need to append your data to the call
		            success: function (data) {
					
		                    if (data == false) {
		                      // $("#alert_box").append("<div class='lert alert-danger alert-dismissible fade show' role='alert'><strong>Data Updated successfully!</strong> You should check in on some of those fields below.<button type='button' id='iderrclose' class='close' data-dismiss='alert' aria-label='Close'><span class='fa fa-times'></span></button></div>");
			                     $( "#button_alert" ).trigger( "click" );   
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
	    	 $.ajax({
		            type: "POST",
		            url: "saveelection",
		            data: {"name":fname}, // fix: need to append your data to the call
		            success: function (data) {
					
		                    if (data == false) {
		                     //  $("#alert_box").append("<div class='lert alert-danger alert-dismissible fade show' role='alert'><strong>Data Updated successfully!</strong> You should check in on some of those fields below.<button type='button' id='iderrclose' class='close' data-dismiss='alert' aria-label='Close'><span class='fa fa-times'></span></button></div>");
		                    $( "#button_alert" ).trigger( "click" );
		                                setTimeout(function(){ 
		                      $('#iderrclose').trigger('click');
		                       

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
	                
}
  
 
  function load_person_list(){
	 /*  myFunction(); */
	/*  load_table(); */
	  $("#tbodyid").empty();
			$.ajax({
	           contentType: "application/json",
	           type: "GET",
	           url: "electionList",
	            success: function (data) {
		          //alert(data);
	           var json = JSON.parse(data);
	           var trHTML = '';
	           var initial_name="",status_name="";
	           
	                    for(var i=0;i<json.length;i++){
	                    	
	                      var id=json[i]['id'];
	                      var name=json[i]['name'];
	                      var regtime=json[i]['regtime'];
	                    
	                            
	                      trHTML +='<tr><th scope="row">'+ id +'</th><td>'+name+'</td><td><span class="status-p bg-danger">'+regtime+'</span></td><td><button type="button" onclick=edit(\''+encodeURIComponent(id)+'\',\''+encodeURIComponent(name)+'\'); class="btn btn-default bg-primary">Edit</button></td><td><button type="button" onclick=delete_fun(\''+encodeURIComponent(id)+'\'); class="btn btn-default bg-danger">Delet</td></tr>';
     
	                 } 
	                    $( "#summary-table tbody" ).append(trHTML);
	                    load_table();
	                             
	              }
	              
	      });
	  }
  
  
  function edit(id,fname){
	
	     $("#id").val((decodeURIComponent(id)));
	     $("#fname").val((decodeURIComponent(fname)));
	    
  
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
    
  
  function delete_fun(id){
	  $.ajax({
          type: "Delete",
          url: "deleteelection",
          data: {"id":id}, // fix: need to append your data to the call
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
	
     if(document.getElementById("fname").value == "") {
         document.getElementById("fname").style.borderColor = "#E34234";
         return false;
    	 }else{
    		 save();
    		 return true;
    	 }
  }
</script>                     