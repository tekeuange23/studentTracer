<%@ page   language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 					   prefix="ng" %>

<ng:set var="id_salle" value="${ selectedSalleId }"></ng:set>
<ng:set var="salle_est_definie" value="${ salleIsSet }"></ng:set>

<!DOCTYPE html>
<html>
	<head>
		<title>Chat</title>
		<link rel="stylesheet" href="../css/chatPage.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">
	
		<script type="text/javascript" src="../scripts/socketEnseignant.jsp" defer></script>
		<script type="text/javascript" src="../scripts/chatPage.js" defer></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.js"></script>
		<!--  -->
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<!------ Include the above in your HEAD tag ---------->
	</head>

	<body>
		<div class="container-fluid h-100">
			<div class="row justify-content-center h-100">
				<!--  LEFT  -->
				<div class="col-md-4 col-xl-3 chat"><div class="card mb-sm-3 mb-md-0 contacts_card">
					<div class="card-header">
						<div class="input-group">
							<input type="text" placeholder="Search..." name="" class="form-control search">
							<div class="input-group-prepend">
								<span class="input-group-text search_btn"><i class="fas fa-search"></i></span>
							</div>
						</div>
					</div>
					
					<div class="card-body contacts_body">
						<ui class="contacts">
							<ng:forEach items="${ salles }" var="salle">
								<li class="salleItem"
									style="cursor: pointer;"
									onclick="changeHiddenInputValue(${ salle.value.id })">
									<div class="d-flex bd-highlight">
										<div class="img_cont">
											<img src="data:image/jpeg;base64,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" 
												 class="rounded-circle user_img">
											<span class="online_icon line"></span>
										</div>
										<div class="user_info">
											<span>${ salle.value.classe.libelle }-${salle.value.libelle}</span>
											<p>left 50 mins ago</p>
										</div>
									</div>
								</li>
							</ng:forEach>
						</ui>
						<script type="text/javascript">
							console.log('Selected: ${ selectedSalleId }')
						</script>
						<form 	
							id="formSalle"
							method="GET" 
				          	action="enseignant" 
				          	style="height: 0px;width: 0px; display: inline;">
							<input
								type="hidden"
			                    id="salle"
			                    name="salle"
			                    style="height: 0px; width: 0px; display: inline;"/>
		                </form>
					</div>
					
					<div class="card-footer"></div>
				</div></div>
				
				
				
				<!--  RIGHT  -->
				<div class="col-md-8 col-xl-6 chat">
					<div class="card">
						<div class="card-header msg_head">
							<div class="d-flex bd-highlight">
								<div class="img_cont">
									<img src="data:image/jpeg;base64,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" 
										 class="rounded-circle user_img">
									<span class="online_icon"></span>
								</div>
								<div class="user_info">
									<span>
										<ng:if test="${ salle_est_definie == true }">
											<ng:out value="Discution ${salles[id_salle].classe.libelle}-${salles[id_salle].libelle}"/>
										</ng:if>
									</span>
									<p>1767 Messages</p>
								</div>
								<div class="video_cam">
									<span><i class="fas fa-video"></i></span>
									<span><i class="fas fa-phone"></i></span>
								</div>
							</div>
							<span id="action_menu_btn"><i class="fas fa-ellipsis-v"></i></span>
							<div class="action_menu">
								<ul>
									<li><i class="fas fa-user-circle"></i> View profile</li>
									<li><i class="fas fa-users"></i> Add to close friends</li>
									<li><i class="fas fa-plus"></i> Add to group</li>
									<li><i class="fas fa-ban"></i> Block</li>
								</ul>
							</div>
						</div>
						
						<div id="messagesArea" class="card-body msg_card_body">	
							<ng:forEach items="${ orderedMessages }" var="message">
								<div class="${ message.enseignant.id == connectedProfId ? 'd-flex justify-content-end mb-4' : 'd-flex justify-content-start mb-4' }">
									<ng:if test="${ message.enseignant.id != connectedProfId }">
										<div class="img_cont_msg">
											<img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg" 
												 class="data:image/jpeg;base64,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"
												 class="rounded-circle user_img_msg">
										</div>
									</ng:if>
									
									<div class="${ message.enseignant.id == connectedProfId ? 'msg_cotainer_send' : 'msg_cotainer' }">
										${ message.message }
										<span class="msg_time_send">${ message.date }</span>
									</div>
									
									<ng:if test="${ message.enseignant.id == connectedProfId }">
										<div class="img_cont_msg">
											<img src="data:image/jpeg;base64,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" 
												 class="rounded-circle user_img_msg">
										</div>
									</ng:if>
								</div>
							</ng:forEach>
						</div>
						
						<div class="card-footer">
							<div class="input-group">
								<div class="input-group-append">
									<span class="input-group-text attach_btn">
										<i class="fas fa-paperclip"></i>
									</span>
								</div>
								<textarea id ="messageToSend" 
										  name="" 
										  class="form-control type_msg" 
										  placeholder="Type your message..."></textarea>
								<div id="sendBtn" class="input-group-append">
									<span class="input-group-text send_btn">
										<i class="fas fa-location-arrow"></i>
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
