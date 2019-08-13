<#import "parts/common.ftl" as a>

<@a.page>
    <h1>добавить книгу</h1>
    <form method="post">
        <div class="form-group row">
            <label for="exampleInputBook">Название книги</label>
            <input type="text" name="name_book" id="exampleInputBook"
                   class="form-control ${(booksError??)?string('is-invalid', '')}"/>
            <#if booksError??>
                <div class="invalid-feedback">
                    ${booksError}
                </div>
            </#if>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
    <h1>Книги</h1>
    <#list books as book>
        <a href="/library/${book.id}">${book.name}</a>
    </#list>
</@a.page>