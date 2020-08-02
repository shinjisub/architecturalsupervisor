<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/config.jspf" %>
<%@ page session="false" %>
<html>
<head>
	<title>${projectNm}</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		var test = util.commonAjax(
			{ url : '/getsupervisoryPlacementList', async : true}
		);
	});
</script>
<body>
	<div class="col-sm-12 col-md-12" style="border:1px solid red;">
		<div class="container text-center">
			<h2 style="margin-top: 10%; float: center;">감리원 배치 계획표</h2>

			<table class="table table-hover mt07">
				<thead class="thead-dark">
					<th>No</th>
					<th>사업명</th>
					<th>생성일</th>
					<th>비고</th>
				</thead>
				<tbody class="thead-light">
					<%-- 
					<c:forEach var="list" varStatus="idx" items="${supervisoryPlacementList}">
						<tr>
							<td>${list.bps_name}</td>
						</tr>
					</c:forEach>
					 --%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
