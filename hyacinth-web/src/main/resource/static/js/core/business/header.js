;
var header = function (headerUrl) {
    return {
        initHeader: function () {
            if (headerUrl == null) {
                headerUrl = "fragment/header.html";
            }
            $("#header").load(headerUrl + " #header1", function () {
                $('#city_picker1').citypicker({
                    province: '华南',
                    city: '广东省',
                    district: '珠海市'
                });
                $('#xiuGaiMiMa').on('click', function () {
                    $('#oldPassword').val('');
                    $('#newPassword').val('');
                    $('#confirmPassword').val('');
                });
                $('#afterChangePasswordConfirmBtn').on('click', function () {
                    $('#changePassword').modal('hide');
                });
                $('#afterChangePassword .close').on('click', function () {
                    $('#changePassword').modal('hide');
                });

                $("#changePasswordForm").bootstrapValidator({
                    container: 'tooltip',
                    feedbackIcons: {
                        valid: 'fa fa-check',
                        invalid: 'fa fa-times',
                        validating: 'fa fa-refresh'
                    },
                    fields: {
                        oldPassword: {
                            validators: {
                                notEmpty: {
                                    message: '密码不能为空'
                                }
                            }
                        },
                        newPassword: {
                            validators: {
                                regexp: {
                                    enable: true,
                                    regexp: /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$/,
                                    message: '请输入8~20位数字和字母的组合'
                                },
                                notEmpty: {
                                    message: '密码不能为空'
                                }
                            }
                        },
                        confirmPassword: {
                            validators: {
                                identical: {
                                    field: 'newPassword',
                                    message: '密码不一致'
                                },
                                regexp: {
                                    enable: true,
                                    regexp: /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$/,
                                    message: '请输入8~20位数字和字母的组合'
                                },
                                notEmpty: {
                                    message: '密码不能为空'
                                }
                            }
                        }
                    }
                });
                $('#changePasswordBtn').on('click', function () {
                    $('#changePasswordForm').data('bootstrapValidator').validate();
                    if ($('#changePasswordForm').data('bootstrapValidator').isValid()) {
                        $.ajax({
                            type: 'POST',
                            url: '/changePassword',
                            dataType: 'json',
                            data: $('#changePasswordForm').serialize(),
                            success: function (data) {
                                if (data.code == 0) {
                                    $('#afterChangePasswordSuccessIcon').css('display', 'none');
                                    $('#afterChangePasswordFailureIcon').css('display', 'block');
                                    $('#afterChangePasswordMsg').html(data.message);
                                    $('#afterChangePassword').modal({backdrop: 'static', keyboard: false});
                                } else {
                                    $('#afterChangePasswordSuccessIcon').css('display', 'block');
                                    $('#afterChangePasswordFailureIcon').css('display', 'none');
                                    $('#afterChangePasswordMsg').html(data.message);
                                    $('#afterChangePassword').modal({backdrop: 'static', keyboard: false});
                                }
                            }
                        })
                    }
                })
            });
        }
    }
};