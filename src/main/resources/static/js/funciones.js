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
        url:"admin-categorias/delete/"+id,
        success : function(res){
        console.log(res);
        }
    });
    swal("¡La categoria ha sido eliminada!", {
      icon: "success",
    }).then((ok) => {
        if(ok){
            location.reload()
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
        url:"admin-posts/delete/"+id,
        success : function(res){
        console.log(res);
        }
    });
    swal("¡El post ha sido eliminado!", {
      icon: "success",
    }).then((ok) => {
        if(ok){
            location.reload()
        }
    });
  } else {
    swal("Se ha cancelado la operacion!");
  }
});


}