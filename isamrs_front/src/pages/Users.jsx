import React from 'react';

import UsersOverview from '../components/UsersOverview';

const users = [
  {
    id: 1,
    name: 'Nikola',
    surname: 'Vujacic',
    phone: '0643996648',
    email: 'john@example.com',
    address: 'Ilije Bircanina 3'
  },
 
];

function Users () {
    return (
        <div>
          <h2>User Overview</h2>
          <UsersOverview users={users} />
        </div>
      );
};

export default Users;