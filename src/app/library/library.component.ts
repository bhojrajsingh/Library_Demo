import { Component, OnInit,ViewChild } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { AgGridAngular } from 'ag-grid-angular';


@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {
@ViewChild('agGrid') agGrid: AgGridAngular;

  constructor(private http:HttpClient) {
   }

  ngOnInit(): void {
  this.loadLibrary();
  }

  public library : any = [];
  public librarydetail : any=[];

public libColDefs = [
          {headerName: 'libID', field: 'libID' , sortable: true, checkboxSelection: true},
          {headerName: 'Library Name', field: 'libName', sortable: true }
            ];

  public bookColDefs = [
            {headerName: 'BookId', field: 'bookId', sortable: true },
            {headerName: 'Book Name', field: 'bookName', sortable: true },
             {headerName: 'Author', field: 'author', sortable: true },
             {headerName: 'Category', field: 'category', sortable: true }
              ];


 private loadLibrary(){
      let localthis =this;
       var promise = this.http.get('/getlibs').toPromise()
       .then(function (response :any) {
       localthis.library=response;
       });
    }

    public loadBooks(){
          const selectedNodes = this.agGrid.api.getSelectedNodes();
          const selectedData = selectedNodes.map( node => node.data );
          const libidtopost = selectedData.map( node => node.libID ).join(', ');

          let localthis =this;
           var promise = this.http.post('/getlibDetail?libId='+libidtopost,{}).toPromise()
           .then(function (response :any) {
           localthis.librarydetail=response;
           });
        }

}
