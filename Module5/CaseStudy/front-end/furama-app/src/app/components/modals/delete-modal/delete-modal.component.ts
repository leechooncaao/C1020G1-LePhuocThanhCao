import { Component, OnInit,Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';


@Component({
  selector: 'app-delete-modal',
  templateUrl: './delete-modal.component.html',
  styleUrls: ['./delete-modal.component.scss']
})
export class DeleteModalComponent implements OnInit {

  form: FormGroup;
  id : number;

  constructor(
      private fb: FormBuilder,
      private dialogRef: MatDialogRef<DeleteModalComponent>,
      @Inject(MAT_DIALOG_DATA) data) {
        this.id = data.id;
  }

  ngOnInit() {
      
  }

  save() {
      this.dialogRef.close(this.id);
  }

  close() {
      this.dialogRef.close();
  }

}
