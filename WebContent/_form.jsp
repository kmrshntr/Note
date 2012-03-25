<jsp:useBean id="noteBean" scope="request" class="sample.NoteBean" />
<form action="/Note/" method="post">
	Title:<input type="text" id="title" name="title" value="<%= noteBean.getTitle() %>" /><br />
	Body:<br />
	<textarea rows=30 cols=40 name="body"><%= noteBean.getBody() %></textarea><br />
	<input type="submit" value="Submit!">
</form>
