//const webSocket = new WebSocket("ws://192.168.8.102:8080/StudentTracer2/chateleveendpoint");
//const webSocket = new WebSocket("ws://localhost:8080/StudentTracer2/chateleveendpoint");
let webSocket = null;
const connect = () => {
  webSocket = new WebSocket("ws://localhost:8080/StudentTracer2/chateleveendpoint");
  setTimeout(bindEvents, 1000);
  //setReadyState();
}
const bindEvents = () => {
    webSocket.onopen = (event) => {
		console.log('onOpenBindEvent');
	}
}
const setReadyState = () => {
  log('ws.readyState: ' + webSocket.readyState);
}
const log = (msg) => {
  if(document.body) {
    var text = document.createTextNode(msg);
    document.body.appendChild(text);
  }
}
connect();




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




const sendBtn = document.getElementById('sendBtn');
const messagesArea = document.getElementById('messagesArea');
const messageToSend = document.getElementById('messageToSend');
console.log(sendBtn);
console.log(messagesArea);
console.log(messageToSend);

webSocket.onopen = (event) => {
	console.log('onOpen');
}
webSocket.onmessage = (message) => {		//si un message arrive
	//console.log(message);
	//alert(`[message] Data received from server: ${message.data}`);
	//let jsonData = JSON.parse(message.data);
	console.log(`[message] de OnMESSAGE`);
	if(message != null){
		messagesArea.value += message.data + '\n';
	}
	///////////////////////////////////////////////////////////////////////////////
	
}


webSocket.onclose = (event) => {
  if (event.wasClean) {
    console.log(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
  } else {
    console.log('[close] Connection died');
  }
}
webSocket.onerror = (err) => {
	console.log(`[error] ${error.message}`);
};




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





const isOpen = (ws) => { 	return ws.readyState === ws.OPEN	}

const sendMessage = () => {
	if (!isOpen(webSocket)) {
		alert('ALERT: CONNECTION FERMEE!!!!!');
	}
	webSocket.send(messageToSend.value);
	console.log('message send!');
	
	///////////////////////////////////////////////////////////////////////////////
	const messageBlock = document.createElement('DIV');	
	messageBlock.className = 'd-flex justify-content-end mb-4';

	var today = new Date();
	var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
	var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
	var dateTime = date+' '+time;

	messageBlock.innerHTML = "<div class='msg_cotainer_send'> ";
	messageBlock.innerHTML +=("<div class='msg_cotainer_send'>" + messageToSend.value +	"<span class='msg_time_send'>"  + dateTime  + "</span></div>");
	messageBlock.innerHTML +="<div class='img_cont_msg'><img src='' class='rounded-circle user_img_msg'></div>";


	messageToSend.value = "";
	messagesArea.appendChild(messageBlock);
	
}
sendBtn.addEventListener('click', sendMessage);