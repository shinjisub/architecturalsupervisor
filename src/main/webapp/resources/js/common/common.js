/**
 * common JS
 */

const util = {
	/**
	 * CommonRetrieveSearch
	 */
	commonAjax : function(config){
		let resultObj = {};
		if(!config){
			console.error('config 값을 넣어주세요');
			return false;
		}

		$.ajax({
			url  : config.url? config.url : '/getRetrieveList.ajax',
			type : config.type? config.type : 'GET',
			data : config.data,
			dataType: config.dataType? config.dataType : 'json',
			async: config.async? config.async : false,
			success : function(e){
				resultObj = e;
				resultObj.resultCode = e.resultCode;
			},
			error : function(e){
				resultObj.errorMessage = e;
				resultObj.resultCode = e.resultCode;
			}
		});
		
		// CallBack Function
		config.callBackFunc? config.callBackFunc(resultObj) : '';
		return resultObj;
	}

	/**
	 * Validation Check
	 * ex) 
 	 *validations :[
 	 *	{id:'search-input', requiredMsg : '검색값을 입력해주세요'}
 	 *]
	 */
  , validation : function(config){
    	if(typeof config != 'object'){
    		common.errorMsgAlert('parameter Error');
    		console.error('parameter Error')
    		return false;
    	}

    	if($.isArray(config.validations)){
	    	$.each(config.validations, function(idx, ele){
	    		const extentArr = ['jpg', 'png'];
		    	let thisEle  = $('#'+ele.id);
		    	let node = thisEle[0].nodeName;
		    	let nodeType = thisEle[0].type;
	
		    	switch(node){
			    	case 'INPUT' :
			    	if(nodeType == 'checkbox'){
				    	if(!$(thisEle).is(':checked')){
				    		common.msgAlert(this.requiredMsg);
					    	return false;
				    	}
			    	}else if(nodeType == 'radio'){
				    	if(!$('input:radio[name='+$(thisEle).attr('name')+']').is(':checked')){
					    	common.msgAlert(this.requiredMsg);
					    	return false; 
				    	}
			    	}else if(nodeType == 'file'){
			    		let thisExtent = thisEle.val().subString(thisEle.val().lastIndexOf('.')+1);
			    		let extentCheck = true;

			    		extentArr.filter(function(){
			    			if(this.value != thisExtent){
			    				extentCheck = false;
			    			}
			    		});
			    		(extentCheck == false)? common.msgAlert('jpg, png 확장자가 적합하지 않습니다.') : '';
			    		return extentCheck
			    	}
			    	break;
		
			    	case 'TEXTAREA' :
				    	// smartEditor
				    	// CkEditor
				    	// SumnailEditor
			    	break;
		    	}
	
	
		    	/* REGEX Validation */
		    	if(ele.regex && ele.regex != null){
			    	let regexArr = (this.regex.indexOf('&') > -1)? this.regex.split('&') : this.regex;
		
			    	/*
			    	var regChk =  /^[a-z]*$/;
			    	var regChk =  /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			    	var regChk =   /\d{3}-\d{3,4}-\d{4}$/;
			    	var regChk = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
			    	*/
		    	}
	
	
		    	/* False Alert */
		    	if($.trim(thisEle.val()) == ''){
		    		common.msgAlert(this.requiredMsg);
			    	return false;
		    	}
	    	});
    	}
  }
}
