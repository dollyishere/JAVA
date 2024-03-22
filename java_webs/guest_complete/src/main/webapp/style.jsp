<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- css 코드 보관 -->
<style>
	.title {
			width: 200px;
	        white-space: nowrap;
	        overflow: hidden;
	        text-overflow: ellipsis;
        }
     .pagenationBtn {
     	border: none;
     	background: none;
     	padding: 0;
     	cursor: pointer;
     	color:#496989;
     	font-weight: bold;
     }
      .right-align {
            float: right;
        }
       .click-button {
            background-color: #496989;
            color: white;
            font-weight: bold;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            cursor: pointer;
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
            border-radius: 12px;
        }
     .table-title {
     	font-weight: bold;
     }
     .title-block {
     	background-color: #58A399;
     	font-weight: bold;
     	color: white;
     }
     table {
    		width: 100%;
            border-collapse: collapse;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            
        }
     th, td {
            padding: 8px;
            text-align: center;
        }
     th {
            text-align: center;
            font-weight: bold;
        }
     body {
    		margin: 40px;
       }
	a {
         text-decoration: none;
         font-weight: bold;
         color: inherit;
         text-overflow:ellipsis;
         width:300;
         overflow:hidden;
        }
	input, textarea {
		border-radius: 12px;
	}
	label {
		font-weight: bold;
	}
	h2 {
		color:#496989;
	}
</style>