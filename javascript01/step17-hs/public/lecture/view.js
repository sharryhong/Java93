var viewTags = $('.bit-view'),
    newTags = $('.bit-new'),
    classroomsTag = $('#fi-classroom'),
    managersTag = $('#fi-manager'),
    fiNo = $('#fi-no'),
    fiTitle = $('#fi-title'),
    fiContent = $('#fi-content'),
    fiStartDate = $('#fi-start-date'),
    fiEndDate = $('#fi-end-date'),
    fiQuantity = $('#fi-quantity'),
    fiHours = $('#fi-hours'),
    fiPrice = $('#fi-price')

var no = 0
try {
  no = location.href.split('?')[1].split('=')[1]
} catch (err) {}

if (no == 0) { // 새 강의 등록
  viewTags.css('display', 'none')

  $('#add-btn').click(function() {
    $.post('add.json', {
      'email': fiEmail.val(),
      'name': fiName.val(),
      'tel': fiTel.val()
    }, function(result) {
      location.href = 'index.html'
    }, 'json')
  })
} else { // 강의 정보 조회
  newTags.css('display', 'none')

  $.getJSON('detail.json', {'no': no}, function(result) {
    fiNo.text(result.result.lno)
    fiTitle.val(result.result.titl)
    fiContent.val(result.result.dscp)
    fiStartDate.val(result.result.sdt2)
    fiEndDate.val(result.result.edt2)
    fiQuantity.val(result.result.qty)
    fiHours.val(result.result.thrs)
    fiPrice.val(result.result.pric)

    var templateFn = Handlebars.compile($('#classrooms-template').text())
    var generatedHTML = templateFn(result)
    classroomsTag.html(generatedHTML)
    classroomsTag.children().filter("option[value=" + result.result.crmno +"]").prop('selected', true)
  })

  $('#upd-btn').click(function() {
    $.post('update.json', {
      'no': fiNo.text(),
      'email': fiEmail.val(),
      'name': fiName.val(),
      'tel': fiTel.val(),
    }, function(result) {
      location.href = 'index.html'
    }, 'json')
  })

  $('#del-btn').click(function() {
    $.getJSON('delete.json', {'no': no}, function(result) {
      location.href = 'index.html'
    })
  })
}






//
