var http= require('http');
var fs = require('fs');

var server =http.createServer((req,res)=>{

    fs.readFile("index.html",function(error,pgResp){
        if(error){
            res.writeHead(404);
            res.write('Contents you are looking are Not Found');
        }else{
            res.writeHead(200,{'Content-Type':'text/html'});
            Response.write(pgResp);
        }
        res.end;
    });
});
server.listen(3000);