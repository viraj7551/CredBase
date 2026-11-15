/**
 * 
 */
function submenu(){
	
	let menuId = document.getElementById("myaccount");
	let accountStatus = menuId.getAttribute("class");
	let subMenu = document.getElementById("submenu_list_option");
	
	if(accountStatus.includes("menu-disable")){
	  menuId.className="menu-enable";
	  subMenu.style.display="block";	
	}else{
		menuId.className="menu-disable";
		subMenu.style.display="none";	
	}
}
function reset(){
    location.reload();
}
function week_credential(){
    let filter_value_alert = document.getElementById("value-alert");
    let filter_emoji = document.getElementById("filtered-value-emoji");
    //change emoji
    filter_emoji.src="./images/sad.png";
    //change filter_value_alert
    filter_value_alert.innerText="Week";
}
function confused_credential(){
    let filter_value_alert = document.getElementById("value-alert");
    let filter_emoji = document.getElementById("filtered-value-emoji");
    //change emoji
    filter_emoji.src="./images/confused.png";
    //change filter_value_alert
    filter_value_alert.innerText="OK";
}
function happy_credential(){
    let filter_value_alert = document.getElementById("value-alert");
    let filter_emoji = document.getElementById("filtered-value-emoji");
    //change emoji
    filter_emoji.src="./images/happy.png";
    //change filter_value_alert
    filter_value_alert.innerText="Strong";
}
function display_result(length, charset){
    let retVal = "";
    for (var i = 0, n = charset.length; i < length; ++i) {
        retVal += charset.charAt(Math.floor(Math.random() * n));
    }
    return retVal;
}
function generateVal(){
let filter_value_display = document.getElementById("value");
let filter_dropdown = document.getElementById("filter_dropdown_list");
let  selected_value = filter_dropdown.value
let checkboxval1 = document.querySelector(".check-options > span > input#check-value1");
let checkboxval2 = document.querySelector(".check-options > span > input#check-value2");
let checkboxval3 = document.querySelector(".check-options > span > input#check-value3");
let checkboxval4 = document.querySelector(".check-options > span > input#check-value4");
let after_filter_value = document.getElementById("lengthVal");
let charset="";
let retVal="";
let length = 0;
let ans =[];
if((selected_value === "6" || selected_value === "9" || selected_value === "12") && ((checkboxval1.checked) && (checkboxval2.checked) && (checkboxval3.checked) && (checkboxval4.checked))){
    if(selected_value === "6" && ((checkboxval1.checked) && (checkboxval2.checked) && (checkboxval3.checked) && (checkboxval4.checked))){
           length = parseInt(selected_value);
           charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789#$&@%";
           retVal = display_result(length, charset);
           ans = retVal;
       week_credential();
    }else if(selected_value === "9" && ((checkboxval1.checked) && (checkboxval2.checked) && (checkboxval3.checked) && (checkboxval4.checked))){
           length = parseInt(selected_value);
           charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789#$&@%";
           retVal = display_result(length, charset);
           ans = retVal;
       confused_credential();
    }else {
           length = parseInt(selected_value);
           charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789#$&@%";
           retVal = display_result(length, charset);
           ans = retVal;
       happy_credential();
    }
}
else{  
    if((selected_value === "6" || selected_value === "9" || selected_value === "12") && ((checkboxval1.checked) && (checkboxval2.checked) && (checkboxval3.checked))){
        if(selected_value === "6" && ((checkboxval1.checked) && (checkboxval2.checked) && (checkboxval3.checked))){
               length = parseInt(selected_value);
               charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
               retVal = display_result(length, charset);
               ans = retVal;
            week_credential();
        }else if(selected_value === "9" && ((checkboxval1.checked) && (checkboxval2.checked) && (checkboxval3.checked))){
               length = parseInt(selected_value);
               charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
               retVal = display_result(length, charset);
               ans = retVal;
           week_credential();
        }else{
               length = parseInt(selected_value);
               charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
               retVal = display_result(length, charset);
               ans = retVal;
            confused_credential();
          }
    }
    else{
        if((selected_value === "6" || selected_value === "9" || selected_value === "12") && (checkboxval1.checked)){
            if(selected_value === "6" && checkboxval1.checked){
                   length = parseInt(selected_value);
                   charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                   retVal = display_result(length, charset);
                   ans = retVal; 
               week_credential(); 
            }else if(selected_value === "9" && checkboxval1.checked){
                   length = parseInt(selected_value);
                   charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                   retVal = display_result(length, charset);
                   ans = retVal; 
               week_credential();
            }else {
                    length = parseInt(selected_value);
                    charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    retVal = display_result(length, charset);
                    ans = retVal;  
               week_credential();
            }
        }else if((selected_value === "6" || selected_value === "9" || selected_value === "12") && (checkboxval2.checked)){
           if(selected_value === "6" && checkboxval2.checked){
               length = parseInt(selected_value);
               charset = "abcdefghijklmnopqrstuvwxyz";
               retVal = display_result(length, charset);
               ans = retVal;
            week_credential();
           }else if(selected_value === "9" && checkboxval2.checked){
                length = parseInt(selected_value);
                charset = "abcdefghijklmnopqrstuvwxyz";
                retVal = display_result(length, charset);
                ans = retVal;
            week_credential();
           }else{
               length = parseInt(selected_value);
               charset = "abcdefghijklmnopqrstuvwxyz";
               retVal = display_result(length,charset);
               ans = retVal;
            week_credential();
           }    
        }else if((selected_value === "6" || selected_value === "9" || selected_value === "12") && (checkboxval3.checked)){
            if(selected_value === "6" && checkboxval3.checked){
                   length = parseInt(selected_value);
                   charset = "0123456789";
                   retVal = display_result(length, charset);
                   ans = retVal;
                week_credential();
            }else if(selected_value === "9" && checkboxval3.checked){
                    length = parseInt(selected_value);
                    charset = "0123456789";
                    retVal = display_result(length, charset);
                    ans = retVal;
                week_credential();
            }else{
                    length = parseInt(selected_value);
                    charset = "0123456789";
                    retVal = display_result(length, charset);
                    ans = retVal;
                week_credential();
            }
        }else if((selected_value === "6" || selected_value === "9" || selected_value === "12") && (checkboxval4.checked)){
               if(selected_value === "6" && checkboxval4.checked){
                    length = parseInt(selected_value);
                    charset = "#$&@%";
                    retVal = display_result(length, charset);
                    ans = retVal;
                week_credential();
               }else if(selected_value === "9" && checkboxval4.checked){
                   length = parseInt(selected_value);
                   charset = "#$&@%";
                   retVal = display_result(length, charset);
                   ans = retVal;
                week_credential();
               }else{
                   length = parseInt(selected_value);
                   charset = "#$&@%";
                   retVal = display_result(length, charset);
                   ans = retVal;
                week_credential();
               }
        }else if((selected_value === "6" || selected_value === "9" || selected_value === "12") && ((checkboxval1.checked) && (checkboxval2.checked))){
               if(selected_value === "6" && ((checkboxval1.checked) && (checkboxval2.checked))){
                   length = parseInt(selected_value);
                   charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                   retVal = display_result(length,charset);
                  ans = retVal;
                week_credential();
               }else if(selected_value === "9" && ((checkboxval1.checked) && (checkboxval2.checked))){
                   length = parseInt(selected_value);
                   charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                   retVal = display_result(length,charset);
                   ans = retVal;
                week_credential();
               }else{
                   length = parseInt(selected_value);
                   charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                   retVal = display_result(length,charset);
                   ans = retVal;
                week_credential();
               }
        }
        else{
              alert("something went wrong, please refresh page and try again...!");
        }    
    }
}
filter_value_display.innerText = ans.toString();
}
function copyClipboard(){
// Select the element by its ID
var filter_value = document.getElementById("value");
// Get the text content of the element
var textToCopy = filter_value.textContent || filter_value.innerText;
// Use the Clipboard API to copy the text
    navigator.clipboard.writeText(textToCopy).then(function() {
      alert('Text copied to clipboard: ' + textToCopy);
    }).catch(function(err) {
      alert('Could not copy text: ', err);
    });
}
function validate1(){
    let username = document.f1.username.value;
	let password = document.f1.password.value;
	username = username.toLowerCase();
	password = password.toLowerCase();
	let user_name_field_alert = document.getElementById("username-alert-label");
	let password_field_alert = document.getElementById("password-alert-label");
		if((username === "" || username === null)&&(password === "" || password === null)){
		    return false;
		}
		else if(username.includes("'") || username.includes("\/") || username.includes("//") || username.includes("--") || username.includes("or") || username.includes("and") || username.includes("union") || (username.includes("^") || username.includes("@") || username.includes("$") || username.includes("%"))){
		    user_name_field_alert.style.display="block";
		    user_name_field_alert.innerText = "please enter correct username";
		    return false;
		    
		}else if(password.includes("'") || password.includes("\/") || password.includes("//") || password.includes("--") || password.includes("or") || password.includes("and") || password.includes("union")){
		    password_field_alert.style.display="block";
		    password_field_alert.innerText = "please enter correct password";
		    return false;
		}
		else{
		    if(username == "" || username == null){
		     return false;
		 }else if(password == "" || password == null){
		     return false;
		  }
		 }
    return true;  
}
function validate2(){
	let firstname = document.f1.firstname.value;
	let lastname = document.f1.lastname.value;
    let username = document.f1.username.value;
	let email = document.f1.email.value;
    let password = document.f1.password.value;
    let confirm_password = document.f1.confirm_password.value;
	
	firstname = firstname.toLowerCase().toString().trim();
	lastname  = lastname.toLowerCase().toString().trim();
	username = username.toLowerCase().toString().trim();
	email = email.toLowerCase().toString().trim();
	password = password.toLowerCase().toString().trim();
	confirm_password = confirm_password.toLowerCase().toString().trim();
	
    let name_alert = document.getElementById("name-alert-label");
	let username_alert = document.getElementById("username-alert-label");
	let email_alert = document.getElementById("email-alert-label");
	let password_alert = document.getElementById("password-alert-label");
	let confirm_pasword_alert = document.getElementById("confirm-password-alert-label");
	
    if((firstname === "" || firstname == null) && (lastname === "" || lastname === "") && (username === "" || username === null) && (email === "" || email === null) && (password === "" || password === null) && (confirm_password === "" || confirm_password === null)){
         return false;
    }
	else if(firstname.includes("'") || firstname.includes("\/") || firstname.includes("select") || firstname.includes("--") || firstname.includes("union") || firstname.includes(":") || firstname.includes("*")){
		name_alert.style.display = "block";
		name_alert.innerText = "please enter correct firstname";
	    return false;
	}
	else if(lastname.includes("'") || lastname.includes("\/") || lastname.includes("select") || lastname.includes("--") || lastname.includes("union") || lastname.includes(":") || lastname.includes("*")){
		name_alert.style.display = "block";
		name_alert.innerText = "please enter correct lastname";
		return false;
	}
	else if(username.includes("'") || username.includes("\/") || username.includes("select") || username.includes("--") || username.includes("union") || username.includes(":") || username.includes("*")){
	    username_alert.style.display="block";
		username_alert.innerText="please enter correct username";
		return false;
	}
	else if(email.includes("'") || email.includes("\/") || email.includes("select") || email.includes("--") || email.includes("union") || email.includes(":") || email.includes("*")){
		email_alert.style.display = "block";
		email_alert.innerText="please enter correct email";
		return false;
	}
	else if(password.includes("'") || password.includes("\/") || password.includes("select") || password.includes("--") || password.includes("union") || password.includes(":") || password.includes("*")){
	    password_alert.style.display = "block";
		password_alert.innerText="please enter correct password";
		return false;
	}else if(confirm_password.includes("'") || confirm_password.includes("\/") || confirm_password.includes("select") || confirm_password.includes("--") || confirm_password.includes("union") || confirm_password.includes(":") || confirm_password.includes("*")){
	     confirm_pasword_alert.style.display = "block";
		 confirm_pasword_alert.innerText="please enter correct confirm password";
		 return false;
	}
	else{
		if(firstname === "" || firstname  === null){
		     return false;
		 }
		else if(lastname === "" || lastname === null){
			return false;
		}
		else if(username === "" || username === null){
		     return false;
		 }
		else if(email === "" || email === null){
			return false;
		}
		else if(password == "" || password == null){
		     return false;
		 }
		else if(confirm_password === "" || confirm_password === null){
			return false;
		}
		else{
			if(firstname.length < 5 || firstname.length > 10){
			   name_alert.style.display="block";
			   name_alert.style.fontSize="10px";
			   name_alert.innerText="firstname characters should be > 5 and < 10 ";
			   return false;
			}
			else if(lastname.length < 5 || lastname.length > 10){
				name_alert.style.display="block";
				name_alert.style.fontSize="10px";
				name_alert.innerText="lastname characters should be > 5 and < 10 ";
				return false;			  	
			}
			else if(username.length < 5 || username.length > 10){
				username_alert.style.display = "block";
				username_alert.style.fontSize="10px";
				username_alert.innerText="username characters should be > 5 and < 10";
				return false;
			}
			else if(email.length < 11 || email.length > 20){
				email_alert.style.display = "block";
				email_alert.style.fontSize="10px";
				email_alert.innerText="email characters should be > 10 and < 20";
				return false;				
			}
			else if(password.length < 5 || password.length > 15){
				password_alert.style.display = "block";
				password_alert.style.fontSize="10px";
				password_alert.innerText="password characters should be > 5 and < 15";
				return false;
			}
			else if(!email.includes("@")){
				email_alert.style.display="block";
				email_alert.style.fontSize="10px";
				email_alert.innerText="please enter correct email";
				return false;
			}
			else if(confirm_password !== password){
				confirm_pasword_alert.style.display = "block";
				confirm_pasword_alert.innerText="entered mismatched password";
			    return false;
			}
		}
	}
    return true;
}

function validate3(){
	let emailVal = document.f1.email.value;
	let email_alert = document.getElementById("email-alert");
	
		if(emailVal.includes("'") || emailVal.includes("select") || emailVal.includes("union") || emailVal.includes(":") || emailVal.includes("--") || emailVal.includes("\/") || emailVal.includes(">") || emailVal.includes("$") || emailVal.includes("or")){
			email_alert.style.display="block";
			email_alert.style.fontSize="12px";
			email_alert.innerText="please enter correct email address";
			return false;
		}
		else if(!emailVal.includes("@")){
			email_alert.style.display="block";
			email_alert.style.fontSize="12px";
			email_alert.innerText="please enter correct email address";
			return false;			
		}		
		else if(emailVal.length < 12 || emailVal.length > 20){
			email_alert.style.display="block";
			email_alert.style.fontSize="12px";
			email_alert.innerText="please enter email character > 12 and < 20";
			return false;		
		}
		else{
			if(emailVal === "" || emailVal === null){
				return false;
			}	
		}
		
	return true;
}

function validate4(){
	let new_password_value = document.f1.newpassword.value;
	let existing_password_value = document.f1.existing_password.value;
	let confirm_existing_password_value = document.f1.confirm_existing_password.value;
	let new_password_alert = document.getElementById("newpassword-alert-label");
	let existing_password_alert = document.getElementById("existing_password-alert-label");
	let confirm_existing_password_alert = document.getElementById("confirm_existing_password-alert-label");

	if((new_password_value === "" || new_password_value === null) && (existing_password_value === "" || existing_password_value === null) && (confirm_existing_password_value === "" || confirm_existing_password_value === null)){
		if(new_password_value === "" || new_password_value === null){
		  return false;	
		}else if(existing_password_value === "" || existing_password_value === null){
		  return false;
		}else{
		  return false;
		}
	}else{
	     if(new_password_value.includes("'") || new_password_value.includes(":") || new_password_value.includes("or") || new_password_value.includes("select") || new_password_value.includes("union") || new_password_value.includes("\/") || new_password_value.includes("--")){
			new_password_alert.style.display="block";
			new_password_alert.style.fontSize="12px";
			new_password_alert.innerText="please enter correct password value";
			return false;
		 }else if(existing_password_value.includes("'") || existing_password_value.includes(":") || existing_password_value.includes("or") || existing_password_value.includes("select") || existing_password_value.includes("union") || existing_password_value.includes("\/") || existing_password_value.includes("--")){
			existing_password_alert.style.display="block";
			existing_password_alert.style.fontSize="10px";
			existing_password_alert.innerText="please enter correct existing password value";
			return false;
		 }
		 else if(confirm_existing_password_value.includes("'") || confirm_existing_password_value.includes(":") || confirm_existing_password_value.includes("or") || confirm_existing_password_value.includes("select") || confirm_existing_password_value.includes("union") || confirm_existing_password_value.includes("\/") || confirm_existing_password_value.includes("--")){
			confirm_existing_password_alert.style.display="block";
			confirm_existing_password_alert.style.fontSize="9px";
			confirm_existing_password_alert.innerText="please enter correct confirm existing password value";
		    return false; 
		}else if(new_password_value === existing_password_value){
			 new_password_alert.style.display="block";
			 new_password_alert.style.fontSize="10px";
			 new_password_alert.innerText="new and existing password cannot be similar";
			 return false;
		}
		else if(confirm_existing_password_value !== existing_password_value){
			confirm_existing_password_alert.style.display="block";
			confirm_existing_password_alert.style.fontSize="12px";
			confirm_existing_password_alert.innerText="mismatched with existing password";
			return false;
		}
		else{
			if(new_password_value.length < 5 || new_password_value.length > 15){
				new_password_alert.style.display="block";
				new_password_alert.style.fontSize="10px";
				new_password_alert.innerText="new password value should be > 5 and < 15";
				return false;
			}else if(existing_password_value.length < 5 || existing_password_value > 15){
				existing_password_alert.style.display="block";
				existing_password_alert.style.fontSize="10px";
				existing_password_alert.innerText="existing password value should be > 5 and < 15";
				return false;
			}
		}	
	}
	return true;
}

function showPassword(){
	let input_value = document.getElementById("mypassword");
	let type = input_value.getAttribute("type");
	if(type.includes("password")){
       input_value.type = "text";
	}else{
       input_value.type="password";
	}
}


