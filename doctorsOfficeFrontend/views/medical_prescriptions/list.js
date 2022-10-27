function loadData(){
    const request = sendRequest('paciente/list', 'GET', '');
    const table = document.getElementById('paciente-table');
    table.innerHTML = "";
    request.onLoad = function(){
        let data = request.response;
        console.log(data);
    }
}