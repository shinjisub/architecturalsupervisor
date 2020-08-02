<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/config.jspf" %>
<%@ page session="false" %>
<html>
<head>
	<title>${projectNm}</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$('.thead-light > tr').on('click', function(e){
			let id = $(this).attr('data-id');
			location.href = gContextPath+'supervisoryPlacement?id='+id;
		});
	});
</script>
<body>
	<div class="col-sm-12 col-md-12" style="border:1px solid red;">
		<div class="container text-center">
			<h2 style="margin-top: 10%; float: left;">감리원 배치 계획표 목록</h2>

			<table class="table table-hover mt07">
				<thead class="thead-dark">
					<th>No</th>
					<th>사업명</th>
					<th>생성일</th>
					<th>비고</th>
				</thead>
				<tbody class="thead-light">
					<c:forEach var="list" varStatus="idx" items="${BusinessSupervisorList}">
						<tr data-id="${list.bpi_id}">
							<td>${idx.count}</td>
							<td>${list.bpi_subject}</td>
							<td>${list.bpi_created}</td>
							<td align="center">
								<button class="btn-danger">삭제</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
