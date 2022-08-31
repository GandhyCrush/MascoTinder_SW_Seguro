var url = [''];
function createButtonListener(love) {
    return function (event) {
        var cards = document
            .querySelectorAll('.tinder--card:not(.removed)');
        var moveOutWidth = document.body.clientWidth * 1.5;

        if (!cards.length)
            return false;

        var card = cards[0];
        card.classList.add('removed');

        if (love) {
            card.style.transform = 'translate(' + moveOutWidth
                + 'px, -100px) rotate(-30deg)';
        } else {
            card.style.transform = 'translate(-' + moveOutWidth
                + 'px, -100px) rotate(30deg)';
        }
        setUrl(url,'like',love);
        setUrl(url,'idCard',card.id);
        sendPost(url);

        event.preventDefault();
    };
}




