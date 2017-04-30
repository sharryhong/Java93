var viewTags = $('.bit-view'),
    newTags = $('.bit-new'),
    fiClassroom = $('#fi-classroom'),
    fiManager = $('#fi-manager'),
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
      'title': fiTitle.val(),
      'content': fiContent.val(),
      'startDate': fiStartDate.val(),
      'endDate': fiEndDate.val(),
      'quantity': fiQuantity.val(),
      'price': fiPrice.val(),
      'hours': fiHours.val(),
      'classroom': fiClassroom.val(),
      'manager': fiManager.val()
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

    var templateFn1 = Handlebars.compile($('#classrooms-template').text())
    var generatedHTML1 = templateFn1(result)
    fiClassroom.html(generatedHTML1)
    fiClassroom.children().filter("option[value=" + result.result.crmno +"]").prop('selected', true)

    var templateFn2 = Handlebars.compile($('#managers-template').text())
    var generatedHTML2 = templateFn2(result)
    fiManager.html(generatedHTML2)
    fiManager.children().filter("option[value=" + result.result.mrno +"]").prop('selected', true)
  })

  $('#upd-btn').click(function() {
    $.post('update.json', {
      'no': fiNo.text(),
      'title': fiTitle.val(),
      'content': fiContent.val(),
      'startDate': fiStartDate.val(),
      'endDate': fiEndDate.val(),
      'quantity': fiQuantity.val(),
      'price': fiPrice.val(),
      'hours': fiHours.val(),
      'classroom': fiClassroom.val(),
      'manager': fiManager.val()
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
