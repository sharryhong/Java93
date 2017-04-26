// nodejs http모듈 필요
var http = require('http')
var server = http.createServer(function(request, response) {
  response.end()
})

module.exports = function() {
  return {
    listen(port, cb) {
      // nodejs http : server.listen
      server.listen(port, cb)
    }
  }
}
