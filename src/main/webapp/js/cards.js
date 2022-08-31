var tinderContainer = document.querySelector('.tinder');
var allCards = document.querySelectorAll('.tinder--card');
var nope = document.getElementById('nope');
var love = document.getElementById('love');

function initCards(card, index) {
	var newCards = document.querySelectorAll('.tinder--card:not(.removed)');
	newCards.forEach(function(card, index) {
		card.style.zIndex = allCards.length - index;
		card.style.transform = 'scale(' + (20 - index) / 20
			+ ') translateY(-' + 30 * index + 'px)';
		card.style.opacity = (10 - index) / 10;
	});

	tinderContainer.classList.add('loaded');
}

initCards();
var nopeListener = createButtonListener(false);
var loveListener = createButtonListener(true);
nope.addEventListener('click', nopeListener);
love.addEventListener('click', loveListener);