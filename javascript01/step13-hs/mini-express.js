module.exports = function() {
  return {
    listen(port, cb) {
      // nodejs http : server.listen
      server.listen(port, cb)
    }
  }
}
