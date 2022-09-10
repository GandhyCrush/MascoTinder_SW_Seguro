<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/likeNoLike.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/banner_style.css">
<title>Like No Like</title>
</head>

<body>
	<div>
		<%@include file="../templates/banner_superior.html"%>
	</div>

	<section>

		<div class="tinder">
			<div
				class="tinder--status <c:if test="${match}">tinder_love</c:if>  ">

				<i class="fa fa-heart"></i>
			</div>

			<div class="tinder--cards">
				<c:forEach items="${mascotas}" var="m">
					<div id="mid${m.idMascota}" class="tinder--card">
						<div id="m${m.idMascota}" class="carousel slide"
							data-bs-ride="carousel">
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#m${m.idMascota}"
									data-bs-slide-to="0" class="active" aria-current="true"
									aria-label="Slide 1"></button>
								<button type="button" data-bs-target="#m${m.idMascota}"
									data-bs-slide-to="1" aria-label="Slide 2"></button>
								<button type="button" data-bs-target="#m${m.idMascota}"
									data-bs-slide-to="2" aria-label="Slide 3"></button>
							</div>
							<button class="carousel-control-prev" type="button"
								data-bs-target="#m${m.idMascota}" data-bs-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Previous</span>
							</button>
							<button class="carousel-control-next" type="button"
								data-bs-target="#m${m.idMascota}" data-bs-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Next</span>
							</button>
							<div class="carousel-inner">
								<div class="carousel-item  active" data-bs-interval="100000000">
									<img src="${m.fotos[0].url}">
								</div>
								<div class="carousel-item" data-bs-interval="100000000">
									<img src="${m.fotos[1].url}">
								</div>
								<div class="carousel-item" data-bs-interval="100000000">
									<img src="${m.fotos[2].url}">
								</div>
							</div>
						</div>
						<h3>${m.nombre}</h3>
						<p>${m.descripcion}</p>
						<p>
							<span class="negrilla">Sexo:</span> ${m.sexo}
						</p>
						<p>
							<span class="negrilla">Edad:</span> ${m.edad}
						</p>
						<p>
							<span class="negrilla">Dueño:</span> ${m.propietario}
						</p>
					</div>
				</c:forEach>
				<div id="mid0" class="tinder--card">

					<h3>Oops!</h3>
					<a class="msg"
						href="${pageContext.request.contextPath}/PreferenciasController?idMiMascota=${idMiMascota}">
						<span>Se acabaron tus Pretendientes <br> Intenta
							actualizando tus Preferencias
					</span>
					</a>


				</div>
			</div>

			<div class="tinder--buttons">
				<button id="noLike">
					<i class="fa fa-remove"></i>
				</button>
				<button id="like">
					<i class="fa fa-heart"></i>
				</button>
			</div>
		</div>


	</section>




	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
		var tinderContainer = document.querySelector('.tinder');
		var allCards = document.querySelectorAll('.tinder--card');
		var noLike = document.getElementById('noLike');
		var like = document.getElementById('like');
		var idCard = '';
		function initCards(card, index) {
			var newCards = document.querySelectorAll('.tinder--card:not(.removed)');
			addTranslateCard(newCards);
			tinderContainer.classList.add('loaded');
		}
		function addTranslateCard(newCards){
			newCards.forEach(function(card, index) {
				card.style.zIndex = allCards.length - index;
				card.style.transform = 'scale(' + (20 - index) / 20
						+ ') translateY(-' + 30 * index + 'px)';
				card.style.opacity = (10 - index) / 10;
			});
		}
		function createButtonListener(isLike) {
			return function(event) {
				var cards = document.querySelectorAll('.tinder--card:not(.removed)');
				if (!cards.length)
					return false;
				var card = cards[0];
				getIdCard(card.id);
				card.classList.add('removed');
				animationCard(card,isLike);
				event.preventDefault();
			};
		}
		function animationCard(card, isLike){
			var moveOutWidth = document.body.clientWidth * 1.5;
			if (isLike) {
				card.style.transform = 'translate(' + moveOutWidth
						+ 'px, -100px) rotate(-30deg)';
			} else {
				card.style.transform = 'translate(-' + moveOutWidth
						+ 'px, -100px) rotate(30deg)';
			}
			sendPostLike(isLike);
			initCards();
		}
		function sendPostLike(like) {
			const http = new XMLHttpRequest();
			var url = './LikeNoLikeController?idCard='+ idCard+'&like='+like;
			http.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					console.log('exito');
				}
			}
			http.open('POST', url, true);
			http.send();
			
		}
		function getIdCard(cardId) {
			idCard = cardId;
		}
		initCards();
		var noLikeListener = createButtonListener(false);
		var likeListener = createButtonListener(true);
		noLike.addEventListener('click', noLikeListener);
		like.addEventListener('click', likeListener);
	</script>
</body>

</html>