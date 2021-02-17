window.addEventListener('load', function() { // 키보드의 모든 동작
   alert('load 완료')
   clearMessages();
   
var formElem=document.querySelector('form');
   formElem.onsubmit=submitForm;

   // 월 추가
var selectInput = document.querySelector('select[name="birth-month"]');
   for(var i=1; i<=12; i++){
   var option = document.createElement('option'); //createElement 태그 만드는것
   option.innerHTML=i+'월';
   option.value=i;
   
   selectInput.appendChild(option); //객체 추가
   
   }
}); 

function clearMessages() {
   var messages=document.getElementsByClassName('alert-message');
   for(var i=0; i<messages.length;i++) {
      messages[i].style.display='none';
   }
}

function showmessage(inputElement, message) {
   var messageElem=inputElement.parentNode.querySelector('span');
   messageElem.style.display='inline';
   messageElem.innerText=message;
   
   inputElement.focus();
}

function submitForm() {
   //account info
   var accountInput = document.querySelector('input[name="account"]');
   var passwordInput = document.querySelector('input[name="password"]');
   var passwordConfirmInput = document.querySelector('input[name="password2"]');
      
   //select, radio, checkbox
   
   var selectInput = document.querySelector('select[name="birth-month"]');
   var radioInput = document.querySelector('input[name="gender"]:checked');
   var checkboxInput = document.querySelector('input[name="agree"]');
   
   console.log(accountInput.value);
   console.log(passwordInput.value);
   console.log(passwordConfirmInput.value);
   
   console.log(selectInput.value);
   console.log(radioInput.value);
   console.log(checkboxInput.value);
   
   var success=true;
   if(accountInput.value.length<6) {
      showmessage(accountInput, '6자리 이상으로 입력해주세요.')
      success=false;
   }
   if(passwordInput.value.length<8) {
      showmessage(passwordInput, '10자리 이상으로 입력해주세요.')
      success=false;
   }
   if(passwordConfirmInput.value !== passwordInput.value) {
      showmessage(passwordConfirmInput, '비밀번호가 일치하지 않습니다.')
      success=false;
   }
   
   return success;
}

