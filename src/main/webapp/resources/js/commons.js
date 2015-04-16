/**
 * Created by ivan_ on 2015/4/16.
 */
$(function(){

    var removeFormValidate = function() {
        var errorsElem = $(".parsley-errors-list");
        var errorsMessageElem = $(".error-message");
        $(errorsElem).remove();
        $(errorsMessageElem).remove();
    }
    $("input, select").on("click", function(){
        removeFormValidate();
    });

});
