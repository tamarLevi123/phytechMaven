
function loadItemsToTable() {
    var body = document.getElementsByTagName('body')[0];
    var tbl = document.createElement('table');
    tbl.style.width = '100%';
    tbl.setAttribute('border', '1');
    var thead= document.createElement('thead');
    var tr = createLine("id","description","price");
    thead.appendChild(tr);
    tbl.appendChild(thead);
    var tbdy = document.createElement('tbody');
    fetch("https://phytech.com/getItems", {
        "referrerPolicy": "strict-origin-when-cross-origin",
        "body": null,
        "method": "GET",
        "mode": "cors",
        "credentials": "include"
    }).then((response) => {
        response.json()
            .then((data) => {
                var tr = createLine(data.id,data.description,data.price);
                tbdy.appendChild(tr);
            });
    });
    tbl.appendChild(tbdy);
    body.appendChild(tbl)
}
function createLine(_id,_desc,_price){
    var tr = document.createElement('tr');
    //id
    var id = document.createElement('td');
    id.appendChild(document.createTextNode(_id));
    id.setAttribute('rowSpan', '2');
    tr.appendChild(id);
    //desc
    var desc = document.createElement('td');
    desc.appendChild(document.createTextNode(_desc));
    desc.setAttribute('rowSpan', '2');
    tr.appendChild(desc);
    //price
    var price = document.createElement('td');
    price.appendChild(document.createTextNode(_price));
    price.setAttribute('rowSpan', '2');
    tr.appendChild(price);
    return tr;
}
loadItemsToTable();