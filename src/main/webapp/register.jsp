<!DOCTYPE html>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-bs-theme="light" lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Register - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <style>
        .toast-center {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            z-index: 1055;
        }
    </style>
</head>
</head>

<body class="bg-gradient-primary" style="background: rgb(2,72,115);">

<div class="toast-container position-fixed bottom-0 end-0 p-3 toast-center">
    <!-- Toast de sucesso -->
    <div id="successToast" class="toast bg-success text-white" role="alert" aria-live="assertive" aria-atomic="true" data-bs-autohide="true" data-bs-delay="3000">
        <div class="toast-header">
            <strong class="me-auto">Sucesso</strong>
            <button type="button" class="btn-close btn-close-white" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Usu�rio cadastrado com sucesso!
        </div>
    </div>
    <!-- Toast de erro -->
    <div id="errorToast" class="toast bg-danger text-white" role="alert" aria-live="assertive" aria-atomic="true" data-bs-autohide="true" data-bs-delay="3000">
        <div class="toast-header">
            <strong class="me-auto">Erro</strong>
            <button type="button" class="btn-close btn-close-white" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            E-mail j� cadastrado.
        </div>
    </div>
</div>

    <div class="container">
        <div class="card shadow-lg o-hidden border-0 my-5">
            <div class="card-body p-0">
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-flex">
                        <div class="flex-grow-1 bg-register-image" style="background: url(assets/img/dogs/F4Y-5-Types-of-Custom-Picture-Frames-Blog-Graphics.png);"></div>
                    </div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h4 class="text-dark mb-4">Criar conta</h4>
                            </div>
                            <form class="user" action="/register" method="post">
                                <div class="row mb-3" style="padding-left: 0px;margin-left: 0px;margin-right: 0px;"><input class="form-control form-control-user" type="text" id="nomeinput" placeholder="Nome completo" name="nome" style="width: 636px;" required></div>
                                <div class="row mb-3">
                                    <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="text" id="cpfinput" placeholder="CPF" name="cpf" required maxlength="14"></div>
                                    <div class="col-sm-6"><input class="form-control form-control-user" type="text" id="telefoneinput" placeholder="Telefone" name="telefone" required maxlength="20"></div>
                                </div>
                                <div class="row mb-3" style="padding-left: 0px;margin-left: 0px;margin-right: 0px;"><input class="form-control form-control-user" type="text" id="enderecoinput" placeholder="Endere�o" name="endereco" style="width: 636px;" required></div>
                                <div class="row mb-3">
                                    <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="text" id="cidadeinput" placeholder="Cidade" name="cidade" required></div>
                                    <div class="col-sm-6"><input class="form-control form-control-user" type="text" id="estadoinput" placeholder="Estado" name="estado" required maxlength="2"></div>
                                </div>
                                <div class="mb-3"><input class="form-control form-control-user" type="email" id="emailinput" aria-describedby="emailHelp" placeholder="Endere�o de email" name="email" required></div>
                                <div class="row mb-3">
                                    <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="password" id="senhainput" placeholder="Senha" name="senha" required></div>
                                    <div class="col-sm-6"><input class="form-control form-control-user" type="password" id="repetirsenhainput" placeholder="Repita a senha" name="repita_senha" required></div>
                                </div><button class="btn btn-primary d-block btn-user w-100" type="submit" style="background: rgb(2,72,115);">Registrar conta</button>
                                <hr>
                                <div style="text-align: center;"><a href="/admin/gerenciarusersADM"><i class="far fa-arrow-alt-circle-left" style="font-size: 43px;color: rgb(2,72,115);"></i></a></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/theme.js"></script>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const form = document.querySelector("form.user");
            const senhaInput = document.getElementById("senhainput");
            const repetirSenhaInput = document.getElementById("repetirsenhainput");

            form.addEventListener("submit", function (event) {
                // Remove qualquer feedback visual pr�vio
                senhaInput.classList.remove("is-invalid");
                repetirSenhaInput.classList.remove("is-invalid");

                if (senhaInput.value !== repetirSenhaInput.value) {
                    // Bloqueia o envio do formul�rio
                    event.preventDefault();
                    event.stopPropagation();

                    // Adiciona o feedback visual de erro
                    senhaInput.classList.add("is-invalid");
                    repetirSenhaInput.classList.add("is-invalid");

                    // Adiciona uma mensagem de erro no campo "Repita a senha"
                    const feedback = document.createElement("div");
                    feedback.className = "invalid-feedback";
                    feedback.textContent = "As senhas n�o coincidem.";
                    if (!repetirSenhaInput.parentElement.querySelector(".invalid-feedback")) {
                        repetirSenhaInput.parentElement.appendChild(feedback);
                    }
                }
            });
        });
    </script>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const status = '<%= request.getAttribute("status") %>';

        if (status === "erro") {
            // Mostra o toast de erro
            const errorToast = new bootstrap.Toast(document.getElementById("errorToast"));
            errorToast.show();
        } else if (status === "sucesso") {
            // Mostra o toast de sucesso
            const successToast = new bootstrap.Toast(document.getElementById("successToast"));
            successToast.show();
        }
    });
</script>

</body>

</html>