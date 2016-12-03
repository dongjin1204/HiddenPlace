if ($(window).width()>500) {
  $('#video-bg iframe').css('display','block');
  $('#video-bg').css('height', $(window).width()*0.57);
}
else $('#video-bg iframe').css('display','none');