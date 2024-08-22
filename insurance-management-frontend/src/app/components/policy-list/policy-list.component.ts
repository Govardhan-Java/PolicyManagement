import { Component, OnInit } from '@angular/core';
import { PolicyService } from '../services/policy.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-policy-list',
  templateUrl: './policy-list.component.html'
})
export class PolicyListComponent implements OnInit {
  policies$: Observable<any>;

  constructor(private policyService: PolicyService) {}

  ngOnInit(): void {
    this.policies$ = this.policyService.getAllPolicies();
  }
}
