function eliminar(id){
swal({
  title: "¿Esta seguro de eliminar esta categoria?",
  text: "",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
    $.ajax({
        url:"categorias/delete/"+id,
        success : function(res){
        console.log(res);
        }
    });
    swal("¡La categoria ha sido eliminada!", {
      icon: "success",
    }).then((ok) => {
        if(ok){
            location.href="/categorias";
        }
    });
  } else {
    swal("Se ha cancelado la operacion!");
  }
});


}


function eliminarPost(id){
swal({
  title: "¿Esta seguro de eliminar este post?",
  text: "",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
    $.ajax({
        url:"posts/delete/"+id,
        success : function(res){
        console.log(res);
        }
    });
    swal("¡El post ha sido eliminado!", {
      icon: "success",
    }).then((ok) => {
        if(ok){
            location.href="/posts";
        }
    });
  } else {
    swal("Se ha cancelado la operacion!");
  }
});


}