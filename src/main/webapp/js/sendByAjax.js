
function sendPost(url) {
    const http = new XMLHttpRequest();
    http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //console.log('exito');
        }
    }
    http.open('POST', url, true);
    http.send();

}
function setUrl(url,nameParameter,parameter) {
    if (url[0] == '') {
        url[0] +='?'+ nameParameter+'=' + parameter;
        
    }else{
        url[0] += '&'+nameParameter+'=' + parameter;
    }
}

