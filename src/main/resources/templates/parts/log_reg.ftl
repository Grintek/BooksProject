<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Логин:</label>
            <div class="col-sm-6">
                <input type="text" name="username" value=" "
                       class="form-control"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="password"
                       class="form-control" placeholder="Password"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
        </div>
        <#if !isRegisterForm><a href="/registration">Новый узер</a></#if>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Создать<#else>Войти</#if></button>
    </form>

</#macro>

<#macro logout>
    <div class="ml-2">
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="Sing Out" class="btn btn-primary">
        </form>
    </div>
</#macro>