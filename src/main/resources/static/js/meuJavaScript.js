$('#confirmaExclusaoModal').on('show.bs.modal', function(event){
		var button = $(event.relatedTarget);
		
		var codigoAluno = button.data('codigo');
		
		var modal = $(this);
		var form = modal.find('form');
		var action = form.attr('action');
		
		if(!action.endsWith('/')){
			action += '/';
		
		}
		
		for.attr('action , action + codigoAluno);
		
		modal.find('.modal-body span').html('Tem certeza que deseja excluir o aluno <strong>' + codigoAluno + '</strong?');
		
		
	});