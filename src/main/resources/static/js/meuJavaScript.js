$('#confirmacaoExclusaoAlunoModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget);
		var codigoAluno = button.data('codigo');
		var modal = $(this);
		var form = modal.find('form');
		var action = form.attr('action');

		if(!action.endsWith('/')){
			action += '/';
		}
		
		form.attr('action' , action + codigoAluno);

		modal.find('.modal-body span').html('Tem certeza que deseja excluir o aluno de código <strong>' + codigoAluno + '</strong?');
		
});